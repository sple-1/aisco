package aisco.donation.creditcard;
import aisco.donation.core.DonationComponent;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;

public class DonationImpl extends DonationComponent {
    String cardNumber;
    String cardHolder;
    String expiryDate;
    String cvv;
    List <DonationImpl> donationList;

    public DonationImpl() {
        System.out.println("\nDonation via Payment Gateway Credit Card");
        donationList = new ArrayList<>();
    }

    public DonationImpl (String name, String email, String phone, int amount, String cardNumber, String cardHolder, String expiryDate, String cvv, String paymentMethod)
    {
        super(name, email, phone, amount, paymentMethod);
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    public String toString() {
        return "- Donasi " + name + ": " + amount + ", Payment Method: " + paymentMethod + " Card Number: " + cardNumber + ", Card Holder: " + cardHolder + "\n";
    }

    public void getDonation() { 
        System.out.println("\nDonation via Payment Gateway Credit Card");
        if (donationList.isEmpty()) {
            System.out.println("No donations have been made yet.");
            return;
        }
        for (DonationImpl donation : donationList) {
            System.out.println(donation.toString());
        }
    }
    

    public void addDonation() {
        // Transaksi pertama
        String name = "Anisa";
        String email = "anisa@gmail.com";
        String phone = "+62878 6654 3321";
        int amount = 2500000;
        String cardNumber = "1234567890123456";
        String cardHolder = "Anisa";
        String expiryDate = "12/2025";
        String cvv = "123";
        String paymentMethod = "Credit Card";
        System.out.println("\nProcessing donation...");
        validateExpiryDate(expiryDate);
        DonationImpl newDonation = new DonationImpl(name, email, phone, amount, cardNumber, cardHolder, expiryDate, cvv, paymentMethod);
        donationList.add(newDonation);
        System.out.println("Donation successful using Credit Card: " + newDonation.maskCardNumber());

        // Transaksi kedua
        name = "Budi Santoso";
        email = "budi.santoso@gmail.com";
        phone = "+62812 3456 7890";
        amount = 1500000;
        cardNumber = "9876543210987654";
        cardHolder = "Budi Santoso";
        expiryDate = "06/2026";
        cvv = "456";
        System.out.println("\nProcessing second donation...");
        validateExpiryDate(expiryDate);
        newDonation = new DonationImpl(name, email, phone, amount, cardNumber, cardHolder, expiryDate, cvv, paymentMethod);
        donationList.add(newDonation);
        System.out.println("Donation successful using Credit Card: " + newDonation.maskCardNumber());
    }


    private void validateExpiryDate(String expiryDate) {
        String[] parts = expiryDate.split("/");
        int month = Integer.parseInt(parts[0]);
        int year = Integer.parseInt(parts[1]);
        
        Calendar now = Calendar.getInstance();
        int currentMonth = now.get(Calendar.MONTH) + 1;
        int currentYear = now.get(Calendar.YEAR) % 100;
        
        if (year < currentYear || (year == currentYear && month < currentMonth)) {
            throw new IllegalArgumentException("Card has expired");
        }
    }

    private String maskCardNumber() {
        if (cardNumber == null) {
            return "****-****-****-****";
        }
        return "****-****-****-" + cardNumber.substring(cardNumber.length() - 4);
    }

}
