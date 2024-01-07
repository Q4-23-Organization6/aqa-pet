public class User {

        public String userName;
        private int age;
        public String email;
        private String password;
        public boolean isActive;
        public double amountSpentMoney;
        public User() {
                System.out.println("Default users constructor");
        }

        public User(String userName) {
                this.userName = userName;
        }
        public User(String userName, String password) {
                this.userName = userName;
                this.password = password;
        }


        public void setUserName(String userName) {
                this.userName = userName;
        }
        public String getUserName() {
                return userName;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getEmail() {
                return email;
        }

        public void setActive(boolean active) {
                isActive = active;
        }

        public boolean isActive() {
                return isActive;
        }

        public void setAmountSpentMoney(double amountSpentMoney) {
                this.amountSpentMoney = amountSpentMoney;
        }

        public double getAmountSpentMoney() {
                return amountSpentMoney;
        }

        public void setAge(int age) {
                if(age >= 18){
                        this.age = age;
                        this.isActive = true;
                }
                else {
                        System.out.println("Is too young");
                }
        }

        public int getAge() {
                return age;
        }

        public void setPassword(String password) {
                if(password.length() >= 8 && password.length() <= 15){
                        this.password = password;
                }
                else {
                        System.out.println("Invalid password");
                }
        }

        public String getPassword() {
                return password;
        }
        public double purchasePrice;

        public void setPurchasePrice(double purchasePrice) {
                this.purchasePrice = purchasePrice;
        }

        public double getPurchasePrice() {
                return purchasePrice;
        }

        public void makePurchase(double purchasePrice) {
                System.out.println("Purchase price: " + purchasePrice);
                amountSpentMoney += purchasePrice;
        }

        public void printTotalAmountOfSpentMoney() {
                System.out.println("Total amount of spent money: " + amountSpentMoney);
        }
    }
