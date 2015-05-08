package com.bquinn.dosing;

class Launcher {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		DosingPump pump = new DosingPump(config, "AlkDose", 35f);
	}

}
