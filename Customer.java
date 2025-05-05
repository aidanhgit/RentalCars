public class Customer{
    private String name;
    private String DOB;
    private String phone;
    private String licenseNum;
    private static int numCustomer = 0;

    //Constructors
    public Customer() {
        
    }
    public Customer(String name, String DOB, String phone, String licenseNum) {
        this.name = name;
        this.DOB = DOB;
        this.phone = phone;
        this.licenseNum = licenseNum;
        numCustomer++;
    }

    //Accessors
    public String getName() {
        return this.name;
    }

    public String getDOB() {
        return this.DOB;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getLicenseNum() {
        return this.licenseNum;
    }

    public static int getNumCustomer(){
        return numCustomer;
    }

    //Mutators
    public void setName(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("name must be provided.");
        }
        this.name = name;
    }

    public void setDOB(String DOB) {
        if (DOB == null || DOB.equals("")) {
            throw new IllegalArgumentException("Date of birth must be provided.");
        } else if (DOB.length() != 10) {
            throw new IllegalArgumentException("Format incorrect.");
        } else {
            this.DOB = DOB;
        }
    }

    public void setPhone(String phone) {
        if (phone == null || phone.equals("")) {
            throw new IllegalArgumentException("Phone number must be provided.");
        } else if (phone.length() != 12) {
            throw new IllegalArgumentException("Format incorrect.");
        } else {
            this.phone = phone;
        }
    }

    public void setLicenseNum(String licenseNum) {
        if (licenseNum == null || licenseNum.equals("")) {
            throw new IllegalArgumentException("License number must be provided.");
        }
        this.licenseNum = licenseNum;
    }

    public static void updateNumCustomer(){
         numCustomer--;
    }

    //Special pupose method
    public String toString() {
        return "Name: " + this.getName() +
        "\nDate of Birth: " + this.getDOB() +
        "\nPhone Number: " + this.getPhone() + 
        "\nLicense Number: " + this.getLicenseNum();
    }
}