package Message;

	public enum Log {
		ERROR ("Error"),
		WARNING ("Warning"),
		EVENT ("Event"),
		MESSAGE ("Message");
	
		private String type;
		
		Log(String type) {
			this.type = type;
		}
		
		public String type() {
			return this.type;
		}
		
		public void send(String msg) {
			System.out.println(type() + ": " + msg);

		}
	}


