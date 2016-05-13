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
    public RaavareBatchDTO getRaavareBatch(int raavareId) throws DALException {
        ResultSet rs = Connector.doQuery("SELECT * FROM raavarebatch WHERE rb_id=?", raavareId);
        try {
            if (!rs.first())
                throw new DALException("RaavareBatch " + raavareId + " findes ikke");
            return new RaavareBatchDTO (rs.getInt("rb_id"), rs.getInt("raavare_id"), rs.getDouble("maengde"));
        }
        catch (SQLException e) {
            throw new DALException(e);
        }
    }
    
    @Override
    public void createRaavareBatch(RaavareBatchDTO raavarebatch) throws DALException {
        Connector.doUpdate(
                "INSERT INTO raavarebatch(raavare_id, rb_id, maengde) VALUES " +
                        "(" + raavarebatch.getRaavareId() + ", '" + raavarebatch.getRbId() + ", '" + raavarebatch.getMaengde() + "')"
        );
    }
    
    @Override
    public void updateRaavareBatch(RaavareBatchDTO raavarebatch) throws DALException {
        Connector.doUpdate(
                "UPDATE raavarebatch SET  raavare_id = '" + raavarebatch.getRaavareId() + "', rb_id =  '" + raavarebatch.getRbId() +
                        "', maengde = '" + raavarebatch.getMaengde()
        );
    }
    
    @Override
    public List<RaavareBatchDTO> getRaavareBatchList() throws DALException {
        List<RaavareBatchDTO> list = new ArrayList<>();
        ResultSet rs = Connector.doQuery("SELECT * FROM raavarebatch");
        try {
            while (rs.next()) {
                list.add(new RaavareBatchDTO(rs.getInt("rbId"), rs.getInt("raavareId"), rs.getDouble("maengde")));
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
        ResultSet rs = Connector.doQuery("SELECT * FROM raavarebatch");
        try {
            while (rs.next()) {
                list.add(new RaavareBatchDTO(rs.getInt("rbId"), rs.getInt("raavareId"), rs.getDouble("maengde")));
            }
        }
        catch (SQLException e) { throw new DALException(e); }
        return list;
    }
}