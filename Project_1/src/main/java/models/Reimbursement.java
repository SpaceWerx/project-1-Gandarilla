package models;

public class Reimbursement {
	
	private int ID;
	private int Author;
	private ReimbursementType Type;
	private Status Status;
	private double Amount;
	private int Resolver;
	private String Description;
	
	
public Reimbursement() {
	super();
}	

//	public Reimbursement(int id2, int i, int j, String string, ReimbursementType travel, models.Status denied,
//			double d) {
//		// TODO Auto-generated constructor stub
//	}
//	public Reimbursement(int i, int id2, String string, ReimbursementType other, models.Status pending, double d) {
//		// TODO Auto-generated constructor stub
//	}

	public Reimbursement(int id, int author, int resolver, String description, ReimbursementType type, Status status, double amount) {
		super();
		this.ID = id;
		Author = author;
		Resolver = resolver;
		Description = description;
		this.Type = type;
		this.Status = status;
		Amount = amount;
	}
	
	public int getId() {
		return ID;
		// TODO Auto-generated method stub
	}
	
	public void setId(int id) {
		this.ID = id;
	}
	
	public int getAuthor() {
		return Author;
	}
	
	public void setAuthor(int author) {
		Author = author;
	}
	
	public int getResolver() {
		return Resolver;
	}
	
	public void setResolver(int resolver) {
		Resolver = resolver;
	}
	
	public void setDescription(String description) {
		Description = description;
	}
	public String getDescription() {
		// TODO Auto-generated method stub
		return Description;
	}
	
	public void setStatus(Status status) {
		this.Status = status;
	}
	
	public models.Status getStatus() {
		// TODO Auto-generated method stub
		return Status;
	}
	
	public double getAmount() {
		return Amount;
		// TODO Auto-generated method stub
		
	}
	
	public void setType(ReimbursementType type) {
		this.Type = type;
		
	}
	
	public ReimbursementType getType() {
		return Type;
	}
	
	public void setAmount(double d) {
		Amount = d;
		
	}
	
	

	
		}