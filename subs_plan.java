package lab2;

class subs_plan
{
	private int subs_type;
	private int play_cap;//plays capacity
	private int down_cap;// download capacity
	private int cost;
	
	public subs_plan(int subs_pref)
	{
		this.plan_assign(subs_pref);
	}
	
	public void plan_assign(int subs_pref)
	{
		this.subs_type = subs_pref;
		switch (subs_pref) {
		case 1:
			this.play_cap=1;
			this.down_cap=0;
			this.cost = 0;
			break;
		case 2:
			this.play_cap=5;
			this.down_cap=2;
			this.cost=100;
			break;
		case 3:
			this.play_cap=10;
			this.down_cap=5;
			this.cost=500;
			break;
		case 4:
			this.play_cap=Integer.MAX_VALUE;
			this.down_cap=Integer.MAX_VALUE;
			this.cost=1000;
			break;
		default:
			break;
		}
}

public int getSubs_type() {
		return subs_type;
	}

	public void setSubs_type(int subs_type) {
		this.subs_type = subs_type;
	}

	public int getPlay_cap() {
		return play_cap;
	}

	public void setPlay_cap(int play_cap) {
		this.play_cap = play_cap;
	}

	public int getDown_cap() {
		return down_cap;
	}

	public void setDown_cap(int down_cap) {
		this.down_cap = down_cap;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	

}
