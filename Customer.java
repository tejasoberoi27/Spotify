package lab2;

import java.util.ArrayList;

class Customer implements User
{
	private static int customer_id = 101;
	private final int id;
	private String name;
	private int plays;
	private int downloads;
	private subs_plan plan;
	
	private int bill = 0 ;
	
	public Customer(String name)
	{
		this.id = customer_id;
		customer_id+=2;
		this.name = name;
		plan = new subs_plan(1);
		this.setDownloads(plan.getDown_cap());
		this.setPlays(plan.getPlay_cap());
	}
	
	
	
	public int getBill() {
		return bill;
	}


	public void calcBill(int new_pref)
	{
		if(this.downloads==plan.getDown_cap() && this.plays==plan.getPlay_cap())
		{//new plan
			this.bill-=plan.getCost();
			plan = new subs_plan(new_pref);
//			System.out.println("plan cost ="+plan.getCost());
//			System.out.println(plan.getSubs_type());
			this.setDownloads(plan.getDown_cap());
			this.setPlays(plan.getPlay_cap());
		}
		this.bill+= plan.getCost();
	}
	
	public void setBill(int bill) {
		this.bill = bill;
	}



	public int getCustomer_id() {
		return customer_id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSubs_type() {
		return plan.getSubs_type();
	}

	

	
	public subs_plan getPlan() {
		return plan;
	}



	public void setPlan(subs_plan plan) {
		this.plan = plan;
	}



	public int getPlays() {
		return plays;
	}

	public void setPlays(int plays) {
		this.plays = plays;
	}

	public int getDownloads() {
		return downloads;
	}

	public void setDownloads(int downloads) {
		this.downloads = downloads;
	}

	public int getId() {
		return id;
	}
	
	public void change_subs(int subs_pref)
	{
		this.calcBill(subs_pref);
	}
	
	@Override
	public void Stream(ArrayList<Song> songs,int num,int song_id,String option)
	{


			
			//small d or capital D
				Song cur = songs.get(song_id);
				if(option.equalsIgnoreCase("D"))
				{
					if(this.downloads>0)
					{
						cur.setDowns(cur.getDowns()+1);
						this.downloads-=1;
					}
					else
					{
						System.err.println("insufficient downloads");
					}
				}
				else if(option.equalsIgnoreCase("P"))
				{
					if(this.plays>0)
					{
						cur.setPlays(cur.getPlays()+1);
						this.plays-=1;
					}
					else
					{
						System.err.println("insufficient plays");
					}

				}
				else
				{
					System.err.println("invalid option - Type D or P");
				}
	}
	@Override
	public int transaction()
	{
		int due = this.bill;
		return due;
	}
	@Override
	public void refresh()
	{
		this.bill=0;
	}



	@Override
	public String Display() {
		String s = this.name+" "+this.id+" "+this.getSubs_type();
		return s;
	}
	
	
	}
	

