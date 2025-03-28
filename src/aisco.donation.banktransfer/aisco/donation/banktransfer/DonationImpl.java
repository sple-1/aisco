package aisco.donation.banktransfer;

import java.util.ArrayList;
import java.util.List;

import aisco.donation.core.DonationComponent;

public class DonationImpl extends DonationComponent {
    String bankAccountNumber;
    List<DonationImpl> donationList;

    public DonationImpl() {
        System.out.println("\nDonation via Bank Transfer");
        donationList = new ArrayList<>();
    }
    
    public DonationImpl(String name, String email, String phone, int amount, String paymentMethod, String bankAccountNumber){
        super(name, email, phone, amount, paymentMethod);
        this.bankAccountNumber = bankAccountNumber;
    }

    public void getDonation(){ 
        for (DonationImpl donation : donationList) {
            System.out.println(
                    String.format(
                            "- Donasi %s: %s Payment Method: %s (Bank Account: %s)%n",
                            donation.name, donation.amount, donation.paymentMethod, donation.bankAccountNumber
                    )
            );
        }
    }

    public void addDonation(){
        String name1 = "Maria Doe";
        String email1 = "johndoe@example.com";
        String phone1 = "+62878 6654 3321";
        int amount1 = 1000000;
        String bankAccount1 = "1234567890"; 
        
        DonationImpl newDonation1 = new DonationImpl(name1, email1, phone1, amount1, "Bank Transfer", bankAccount1);
        donationList.add(newDonation1);

        String name2 = "Jane Maria";
        String email2 = "janesmith@example.com";
        String phone2 = "+62812 3344 5566";
        int amount2 = 1500000;
        String bankAccount2 = "9876543210";
        
        DonationImpl newDonation2 = new DonationImpl(name2, email2, phone2, amount2, "Bank Transfer", bankAccount2);
        donationList.add(newDonation2);

        String name3 = "Robert MAria";
        String email3 = "robertbrown@example.com";
        String phone3 = "+62856 7788 9900";
        int amount3 = 2000000;
        String bankAccount3 = "1122334455";
        
        DonationImpl newDonation3 = new DonationImpl(name3, email3, phone3, amount3, "Bank Transfer", bankAccount3);
        donationList.add(newDonation3);
    }
}
