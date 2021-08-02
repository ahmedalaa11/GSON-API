package tsk;

import test.API;

public class tsk {
	public static void main(String[] args) {
		
		//instantiating an object API
		API api = new API();
		
		//Read topology from disk into memory
		String FileName ="C:\\Users\\Ahmed Alaa\\eclipse\\test\\test\\topology.json";
		api.readJson(FileName);
		
		//Write topology from memory to desk
		api.writeJson("top1");
		
		//query topologies in memory
		api.queryTopologies();
		
		//delete topology from memory
		//api.deleteTopology("top1");
		
		//query topologies in memory
		//api.queryTopologies();
		
		//query devices with topology id
		api.queryDevices("top1");
		
		//Query Devices With Topology ID and Netlist Node ID
		api.queryDevicesWithNetlistNode("top1", "vss");
			
}
}
