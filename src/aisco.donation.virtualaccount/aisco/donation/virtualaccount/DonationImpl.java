package aisco.donation.virtualaccount;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import aisco.donation.core.DonationComponent;

public class DonationImpl extends DonationComponent {
	String accountNumber;
    List <DonationImpl> donationList;

    public DonationImpl() {
        System.out.println("\nDonation via Payment Gateway");
        donationList = new ArrayList<>();
    }
    
    public DonationImpl (String name, String email, String phone, int amount, String paymentMethod){
        super(name, email, phone, amount, paymentMethod);
    }

    public void getDonation(){ 
    	for (DonationImpl donation : donationList) {
    		System.out.println(
    				String.format(
    						"- Donasi %s: %s Payment Method: %s (Account Number: %s)%n",
    						donation.name, donation.amount, donation.paymentMethod, donation.accountNumber
    				)
    		);
    	}
    }

    public void addDonation(){
    	String name1 = "John Doe";
    	String email1 = "johndoe@example.com";
    	String phone1 = "+62878 6654 3321";
    	int amount1 = 1000000;
    	
    	DonationImpl newDonation1 = new DonationImpl(name1, email1, phone1, amount1, "Virtual Account");
    	newDonation1.accountNumber = String.format(
    			"%d%s%06d",
    			(int) Character.toUpperCase(name1.trim().charAt(name1.length() - 1)),
    			phone1.substring(phone1.length() - 4),
    			new Random().nextInt(999999)
    	);
    	
    	donationList.add(newDonation1);
    	System.out.println("Donation Added!");
    	
    	String name2 = "Jane Smith";
    	String email2 = "janesmith@example.com";
    	String phone2 = "+62812 3344 5566";
    	int amount2 = 1500000;
    	
    	DonationImpl newDonation2 = new DonationImpl(name2, email2, phone2, amount2, "Virtual Account");
    	newDonation2.accountNumber = String.format(
    			"%d%s%06d",
    			(int) Character.toUpperCase(name2.trim().charAt(name2.length() - 1)),
    			phone2.substring(phone2.length() - 4),
    			new Random().nextInt(999999)
    	);
    	
    	donationList.add(newDonation2);
    	System.out.println("Donation Added!");

    	String name3 = "Robert Brown";
    	String email3 = "robertbrown@example.com";
    	String phone3 = "+62856 7788 9900";
    	int amount3 = 2000000;
    	
    	DonationImpl newDonation3 = new DonationImpl(name3, email3, phone3, amount3, "Virtual Account");
    	newDonation3.accountNumber = String.format(
    			"%d%s%06d",
    			(int) Character.toUpperCase(name3.trim().charAt(name3.length() - 1)),
    			phone3.substring(phone3.length() - 4),
    			new Random().nextInt(999999)
    	);
    	
    	donationList.add(newDonation3);
    	System.out.println("Donation Added!");
    }

}
