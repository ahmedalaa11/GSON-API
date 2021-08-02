package test;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

import com.google.gson.*;

public class API {
	// List topologies acts as a memory for loading and manipulating Topologies
	private static List<Topology> topologies = new ArrayList<Topology>();
	
	
	public void readJson(String File) {
	// readJson Method Load Topology From .json File Into Memory
	// Arguments: Path To .json File (String)
	// Returns: None
		
		Gson gson = new Gson();
		
		Topology top = null;
		Reader reader;
		try {
			reader = new FileReader(File);
			top = gson.fromJson(reader, Topology.class);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		topologies.add(top);
	}
	
	public void writeJson(String id) {
	// writeJson Method Saves A Given Topology From Memory Into A .json File
	// Arguments: Topology ID (String)
	// Returns: None
		
		for(Topology i : topologies) {
			if(id.equals(i.id)) {
				// pretty print
		        Gson gson = new GsonBuilder().setPrettyPrinting().create();

		        // Java objects to File
		        try (FileWriter writer = new FileWriter("C:\\Users\\Ahmed Alaa\\eclipse\\test\\test\\task.json")) {
		            gson.toJson(i, writer);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		       return; 
			}
			
		}
	}
	
	public Vector<Topology> queryTopologies() {
	// queryTopologies Method Gets All Topologies Loaded Into The Memory
	// Arguments: None
	// Returns: Vector of Topologies
		System.out.println("queryTopologies:");
		Vector <Topology> top = new Vector<Topology>();
		
		for(Topology i : topologies) {
			top.add(i);
			System.out.println(i.id);
		}
		return top;
	}
	
	public void deleteTopology(String id) {
	// deleteTopology Method Removes A Given Topology From The Memory
	// Arguments: Topology ID (String)
	// Returns: None
		
		for (Topology i :topologies) {
			if(id.equals(i.id)) {
				topologies.remove(i);
				return;
			}
		}
	}
	
	public Vector<? super Component> queryDevices(String id){
	// queryDevices Method Gets All Devices/Components Of A Given Topology
	// Arguments: Topology ID (String)
	// Returns: Vector of Devices/Components
		System.out.println("queryDevices:");
		for(Topology i : topologies) {
			if(id.equals(i.id)) {
				for(int x=0;x<i.components.size();x++) 
				{
					System.out.println((i.components.get(x)));
				}
				return i.components;
			}
		}
		return null;
	}
	
	public Vector<? super Component> queryDevicesWithNetlistNode(String TopologyId,String NetlistNodeID){
	// queryDevicesWithNetlistNode Method Gets All Devices/Components Connected To A Given Node In A Given Topology
	// Arguments: Topology ID (String), Netlist Node ID (String)
	// Returns: Vector Of Devices/Components
		System.out.println("queryDevicesWithNetlistNode:");
		
		Vector myVector = new Vector <Component>();
		
		for(Topology i : topologies) {
			if(TopologyId.equals(i.id)) {
				for (Integer j = 0; j < i.components.size(); j++)
		        {	
		            Gson gsonn = new GsonBuilder().setPrettyPrinting().create();

			        String comp = gsonn.toJson(i.components.get(j));
		        	if(comp.contains(NetlistNodeID)) 
		        	{
		        		myVector.add(i.components.get(j));
		        		
		        		System.out.println(i.components.get(j));
		        	}
		        }
		}
		}
		return myVector;
	}

}