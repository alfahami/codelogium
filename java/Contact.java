public class Contact {
        private String name;
        private String phone;
        private String email;
        private String category;

        public Contact(String name, String phone, String email, String category) {
            this.name = name;
            this.phone = phone;
            this.email = email;
            this.category = category;
        }

        public String getName()  { return this.name;  }
        public String getPhone() { return this.phone; }
        public String getEmail() {return this.email;  }
        public String getCategory() { return this.category; }

        public void setName(String name)   { this.name = name;   }
        public void setPhone(String phone) { this.phone = phone; }
        public void setEmail(String email) { this.email = email; }
        public void setCategory(String category) { this.category = category; }

        public String toString() {
            return "Contact Info :" + " Name :" + name + " | " + "Phone: " + phone + " | " + "Email: " + email + " |" + "Category: " + category;
        }
}
