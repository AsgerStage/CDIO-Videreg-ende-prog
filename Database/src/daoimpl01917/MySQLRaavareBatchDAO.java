package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.RaavareBatchDAO;
import dto01917.RaavareBatchDTO;

public class MySQLRaavareBatchDAO implements RaavareBatchDAO
{
    @Override
    public RaavareBatchDTO getRaavareBatch(int rb_id) throws DALException {
        ResultSet rs = Connector.doQuery("SELECT * FROM raavarebatch WHERE rb_id=?", rb_id);
        try {
            if (!rs.first())
                throw new DALException("RaavareBatch " + rb_id + " findes ikke");
            return new RaavareBatchDTO (rs.getInt("rb_id"), rs.getInt("raavare_id"), rs.getDouble("maengde"));
        }
        catch (SQLException e) {
            throw new DALException(e);
        }
    }
    
    @Override
    public void createRaavareBatch(RaavareBatchDTO raavarebatch) throws DALException {
        Connector.doUpdate("INSERT INTO raavarebatch(raavare_id, rb_id, maengde) VALUES(?, ?, ?)",
                raavarebatch.getRaavareId(), raavarebatch.getRbId(), raavarebatch.getMaengde()
        );
    }
    
    @Override
    public void updateRaavareBatch(RaavareBatchDTO raavarebatch) throws DALException {
        Connector.doUpdate("UPDATE raavarebatch SET raavare_id=?, maengde=? WHERE rb_id=?",
                raavarebatch.getRaavareId(), raavarebatch.getMaengde(), raavarebatch.getRbId()
        );
    }
    
    @Override
    public List<RaavareBatchDTO> getRaavareBatchList() throws DALException {
        List<RaavareBatchDTO> list = new ArrayList<>();
        ResultSet rs = Connector.doQuery("SELECT * FROM raavarebatch");
        try {
            while (rs.next()) {
                list.add(new RaavareBatchDTO(rs.getInt("rb_id"), rs.getInt("raavare_id"), rs.getDouble("maengde")));
            }
        }
        catch (SQLException e) {
            throw new DALException(e);
        }
        return list;
    }
    
    @Override
    public List<RaavareBatchDTO> getRaavareBatchList(int raavareId) throws DALException {
        List<RaavareBatchDTO> list = new ArrayList<>();
        ResultSet rs = Connector.doQuery("SELECT * FROM raavarebatch WHERE raavare_id=?", raavareId);
        try {
            while (rs.next()) {
                list.add(new RaavareBatchDTO(rs.getInt("rb_id"), rs.getInt("raavare_id"), rs.getDouble("maengde")));
            }
        }
        catch (SQLException e) { throw new DALException(e); }
        return list;
    }

    public void deleteRaavareBatch(int rb_id) throws DALException {
        Connector.doUpdate("CALL `DTU`.`delete_raavare_batch`(?)", rb_id);
    }
}