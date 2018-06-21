//Interface to provide behaviour to Transport entities like Bus, Train, Flight
package com.DAOInterface;

import java.sql.ResultSet;
import com.exceptions.InvalidBusId;
import com.exceptions.InvalidFlightId;
import com.exceptions.InvalidTrainId;

public interface TransInterface 
{
	public ResultSet search();
	public int updateBook(int bId) throws InvalidBusId, InvalidTrainId, InvalidFlightId;	
	public int updateCancel(int bId) throws InvalidBusId, InvalidTrainId, InvalidFlightId;
}
