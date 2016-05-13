package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ProduktBatchDAO;
import dto01917.ProduktBatchDTO;

public class MySQLProduktBatchDAO implements ProduktBatchDAO
{
    @Override
    public ProduktBatchDTO getProduktBatch(int pbId) throws DALException {
        ResultSet rs = Connector.doQuery("SELECT * FROM get_produktbatchs WHERE pb_id=?", pbId);
        try {
            if(!rs.first()) 
                throw new DALException("Produktbatch " + pbId + " Findes ikke");
            return new ProduktBatchDTO (rs.getInt("pb_id"), rs.getInt("status"), rs.getInt("recept_id"));
        }
        catch(SQLException e){
            throw new DALException(e);
        }
    }
    
    @Override
    public List<ProduktBatchDTO> getProduktBatchList() throws DALException {
        List<ProduktBatchDTO> list = new ArrayList<>();
        ResultSet rs = Connector.doQuery("SELECT * FROM get_produktbatchs");
        try {
            while (rs.next()) {
                list.add(new ProduktBatchDTO(rs.getInt("pb_id"), rs.getInt("status"), rs.getInt("recept_id")));
            }
        }
        catch (SQLException e) { 
            throw new DALException(e); 
        }
        return list;
    }
    
    @Override
    public void createProduktBatch(ProduktBatchDTO produktbatch) throws DALException {
        Connector.doUpdate("INSERT INTO produktbatch(pb_id, status, recept_id) VALUES(?, ?, ?)",
                produktbatch.getPbId(), produktbatch.getStatus(), produktbatch.getReceptId());
    }
    
    @Override
    public void updateProduktBatch(ProduktBatchDTO produktbatch) throws DALException {
        Connector.doUpdate("UPDATE produktbatch SET status=?, recept_id=? WHERE pb_id=?",
                produktbatch.getStatus(), produktbatch.getReceptId(), produktbatch.getPbId());
    }

    public void deleteProduktBatch(int pbId) throws DALException {
        Connector.doUpdate("CALL `DTU`.`delete_produkt_batch`(?)", pbId);
    }
}