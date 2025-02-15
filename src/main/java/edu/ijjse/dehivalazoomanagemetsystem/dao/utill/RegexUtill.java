package edu.ijjse.dehivalazoomanagemetsystem.dao.utill;

public class RegexUtill {
    public static boolean IsValidEmail(String email) {
        String emailPattern = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        return email.matches(emailPattern);
    }
    public static boolean IsValidPhone(String phone) {
        String phonePattern = "^(\\+?[0-9]{10})?$";
        return phone.matches(phonePattern);
    }
    public static boolean IsValidName(String name) {
        String namePattern = "^[a-zA-Z0-9_-]+$";
        return name.matches(namePattern);
    }
    public static boolean IsvalidAge(String age) {
        String agePattern = "^(?:1[01][0-9]|120|[1-9]?[0-9])(?:\\.(?:[0-9]|1[01]))?$";
        return age.matches(agePattern);
    }
   public static boolean IsValidAmount(String amount) {
        String amountPattern = "^\\d+(\\.\\d{1,2})?$";
        return amount.matches(amountPattern);
   }

   public static boolean IsValidDate(String date) {
        String datePattern = "^[0-9]{4}$";
        return date.matches(datePattern);
   }
   public static boolean IsValidGender(String gender) {
        String genderPattern ="^(Male|male|Female|female)$";
        return gender.matches(genderPattern);
   }
   public static boolean IsValidSalary(String salary) {
        String salaryPattern = "^\\d+(\\.\\d{1,2})?$";
        return salary.matches(salaryPattern);
   }
   public static boolean IsValidSize(String size) {
        String sizePattern = "^\\d{1,4}x\\d{1,4}x\\d{1,4}$";
        return size.matches(sizePattern);
   }
   public static boolean IsValidQuantity(String quantity) {
        String quantityPattern = "^\\d+$";
        return quantity.matches(quantityPattern);
   }
   public static boolean isValueDoc(String doc) {
        String docPattern = "^(Dr\\.|dr\\.)?\\s?[a-zA-Z]+(?:\\s[a-zA-Z]+)*(?:\\s(MD|PhD|DO))?$";
        return doc.matches(docPattern);
   }
   public static boolean isValidNic(String nic) {
       String nicPattern = "^[0-9]{9}[vVxX]||[0-9]{12}$";
        return nic.matches(nicPattern);
   }
}
