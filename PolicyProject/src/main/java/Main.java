import dao.CustomerDao;
import model.*;
import java.util.List;
import java.util.Scanner;

import service.ClaimService;
import service.SimpleClaimProcessor;
public class Main
{
    private static final CustomerDao CUSTOMER_DAO = new CustomerDao();
    static Scanner sc = new Scanner(System.in);
    private static final ClaimService CLAIM_SERVICE = new ClaimService(new SimpleClaimProcessor());
    public static void main(String[] args) throws Exception {

        while(true)
        {
            printMenu();
            System.out.println("Enter your choice:");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    registerCustomer();
                    break;

                case 2:
//                    registerPolicy();   // we'll create this next
                    break;

                case 3:
                    registerClaim();
                    break;

                case 4:
                    processClaim();
                    break;

                case 5:
                    viewClaims();
                    break;

                case 6:
                    searchClaim();
                    break;

                case 7:
                    System.out.println("Exit");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }


    }

    private static int claimCounter = 1001;

    private static String generateClaimId() {
        return "CLM" + claimCounter++;
    }
    private static void searchClaim() {
        System.out.print("Enter Claim ID: ");
        String claimId = sc.next();

        Claim claim = CLAIM_SERVICE.findClaimById(claimId);

        System.out.println(
                claim == null
                        ? "Claim not found."
                        : claim.getSummary()
        );
    }
    private static void viewClaims() {
        List<Claim> claims = CLAIM_SERVICE.viewAllClaims();

        if (claims.isEmpty()) {
            System.out.println("No claims available.");
            return;
        }

        for (Claim claim : claims) {
            System.out.println(claim.getSummary());
        }
    }
    private static void processClaim()
    {
        System.out.print("Enter Claim ID to process: ");
        String claimId = sc.next();

        Claim claim = CLAIM_SERVICE.findClaimById(claimId);

        if (claim == null) {
            System.out.println("Claim not found.");
            return;
        }

        if (claim.getStatus() != Status.REGISTERED) {
            System.out.println("Claim has already been processed.");
            return;
        }

        Status status = CLAIM_SERVICE.processClaim(claimId);

        System.out.println("Claim processed. Current status: " + status);
        System.out.printf("Approved amount: %.2f%n", claim.getApprovedAmount());

        if (!claim.getRejectionReason().isBlank())
        {
            System.out.println("Reason: " + claim.getRejectionReason());
        }

    }
    private static void registerClaim() {

        System.out.println();
        System.out.println("Claim Types: 1. Health 2. Vehicle 3. Property");
        System.out.print("Enter claim type: ");
        int type = sc.nextInt();

        System.out.print("Enter customer id: ");
        String customerId = sc.next();

        System.out.print("Enter customer name: ");
        String customerName = sc.next();

        System.out.print("Enter Phone number: ");
        String phone = sc.next();

        Customer customer = new Customer(customerId, customerName, phone);

        System.out.print("Policy Id : ");
        String policyId = sc.next();

        System.out.print("Sum Insured : ");
        double sumInsured = sc.nextDouble();

        System.out.print("Premium Amount: ");
        double premium = sc.nextDouble();

        System.out.print("Claim Amount: ");
        double claimAmount = sc.nextDouble();

        Policy policy;
        Claim claim;

        switch (type) {

            case 1:
                policy = new HealthPolicy(policyId, customer, sumInsured, premium);
                claim = new HealthClaim(generateClaimId(), policy, claimAmount);
                break;

            case 2:
                policy = new VehiclePolicy(policyId, customer, sumInsured, premium);
                claim = new VehicleClaim(generateClaimId(), policy, claimAmount);
                break;

            case 3:
                policy = new PropertyPolicy(policyId, customer, sumInsured, premium);
                claim = new PropertyClaim(generateClaimId(), policy, claimAmount);
                break;

            default:
                System.out.println("Unsupported claim type.");
                return;
        }

        CLAIM_SERVICE.addClaim(claim);

        System.out.println(
                "Claim registered successfully with ID: "
                        + claim.getClaimID()
        );
    }

    public static void printMenu()
    {
        System.out.println();
        System.out.println("Insurance claim Procesing");
        System.out.println("1. Register Customer");
        System.out.println("2.Register Policy" );
        System.out.println("3. Register New Claim");
        System.out.println("4. Process Claim");
        System.out.println("5. View All Claims");
        System.out.println("6. Search Claim By Id");
        System.out.println("7. Exit");
    }

//    private static void sampleData() throws Exception {
//
//
//        CustomerDao dao =
//                new CustomerDao();
//
//        Customer customer =
//                new Customer(
//                        "C101",
//                        "Jake",
//                        "9876543210"
//                );
//
//        dao.addCustomer(customer);
//
//        Policy policy = new HealthPolicy(
//                "P1001",
//                customer,
//                500000,
//                18000
//        );
//
//        Claim claim = new HealthClaim(
//                generateClaimId(),
//                policy,
//                125000
//        );
//
//        CLAIM_SERVICE.addClaim(claim);
//    }

    private static void registerCustomer() {

        System.out.print("Enter Customer ID: ");
        String customerId = sc.next();

        System.out.print("Enter Customer Name: ");
        String customerName = sc.next();

        System.out.print("Enter Phone Number: ");
        String phone = sc.next();

        Customer customer = new Customer(customerId, customerName, phone);

        try {

            CUSTOMER_DAO.addCustomer(customer);

            System.out.println("Customer Registered Successfully.");

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

}
