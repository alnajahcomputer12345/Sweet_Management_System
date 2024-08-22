package myAPP2024;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.List;
import java.util.*;


public class myappsweet {
	boolean pricefill=false;

        public static Map<String, Message> getMessages() {
		return messages;
	}

	public void setMessages(Map<String, Message> messages) {
		this.messages = messages;
	}
   private List<Recipe> filteredrecipes = new ArrayList<Recipe>();
   private static Map<String,Material > allMaterials = new HashMap<String, Material>();

		public static Map<String, Message> messages = new HashMap<String, Message>();
	    public static Map<String, User> users = new HashMap<String, User>();
	    private Map<String, User> admins = new HashMap<String, User>();
	    private static Map<String, User> owners = new HashMap<String, User>();
	    public static Map<String, User> rawSuppliers = new HashMap<String, User>();
	    private Map<String, Recipe> allRecipe= new HashMap<String, Recipe>();
	    public static Map<String, Product> products = new HashMap<String, Product>();
        
	    public static void setOwners(Map<String, User> owners) {
			myappsweet.owners = owners;
		}
        
		public void setRawSuppliers(Map<String, User> rawSuppliers) {
			this.rawSuppliers = rawSuppliers;
		}
		public boolean islogged;
	    public boolean isRecipeupdated;
	    public boolean first;
		public boolean isproductFilled;
		public boolean isexist;
		public String forgettenfield;

	    
		public void printpagename() {
			System.out.println("You are in the add new product")	;	
			
		}
        
		public boolean checkifexist(String string) {
			// TODO Auto-generated method stub
			for (Product obj : products.values()) {
	            if (obj.getName_of_product().equals(string)) {
	//System.out.println("This product is exist");
	return true;
	            }
			}
			//System.out.println("The product not exist in system");
			return false;		
		}
		
		public void checkifpricefill(Product p) {
			if(p.getPrice()==0.0)
		    	System.out.println("You missing an important details");	
			else
				pricefill=true;
		}

		public void printerrormessage() {
			System.out.println("You can not add this product you missing an important details");
			
		}


		public boolean checkifexisttoremove(Product p) {
			for (Product obj : products.values()) {
		        if (obj.getNum_product() == p.getNum_product() && obj.getName_of_product().equals(p.getName_of_product())) {
		            System.out.println("This product exists");
		            return true;
		        }
		    }
		    System.out.println("This product does not exist");
		    return false;
		}

		public void RemoveProduct(Product p) {
			if(EnterAllRequieredToDelete(p)) {
            if(checkifexisttoremove(p)) {
			products.remove(String.valueOf(p.getNum_product()));
			System.out.println("Remove done successfully");}
            
            else
            	System.out.println("This product not exist");
			}
			else
				System.out.println("Sorry ,You miss an important details");
			
		}

		public void printproductnotexist() {
	System.out.println("This product not exist");		
		}

		public boolean EnterAllRequieredToDelete(Product p) {
			// TODO Auto-generated method stub
			if(p.getName_of_product()!=" " && p.getNum_product()!=0)
				return true;
			else {
				if(p.getName_of_product()==" ") {
					
				
					forgettenfield= "product name";}
					else 
						forgettenfield= "product number";
		
		        System.out.println("You may forget to enter an important detail: " + forgettenfield);
				}
				return false;
		
			}


		
		public void addnewProduct(Product p) {
		
			String x=String.valueOf(p.getNum_product());
			boolean b=false;
	        for (HashMap.Entry<String, Product> entry : products.entrySet()) {
	        	Product product = entry.getValue();
	        	if(product.getNum_product()==p.getNum_product())
	        		b=true;
	        }
			 
			
			if(checkifexist(p.getName_of_product()) || b) {
				System.out.println("The product is exist OR check your datat well");
				return;
			}
			else {
				checkifpricefill(p);
				if(pricefill && p.getNum_product()!=0 &&p.getName_of_product()!="" && p.getCount()!=0) {
					products.put(x, p);
					System.out.println("Adding Product Successfully");
					}
			
			else
				System.out.println("Sorry check the data you entered , there is a missing data");}}
		//	products.put(x, p);}

		

		public void printDone() {
			System.out.println("Adding Done");
			
		}

		public void viewlistofproducts() {
			
				 for (String key : products.keySet()) {
	 	            System.out.println("Key: " + key + ", Value: " + products.get(key));
	 	        }
		}

		public Map<String, Recipe> getAllRecipe() {
			return allRecipe;
		}

		public void setAllRecipe(Map<String, Recipe> allRecipe) {
			this.allRecipe = allRecipe;
		}

		public boolean isRegistered;
	    private User activeuser; 
	    private boolean exit;

	        public myappsweet() {
	        users.put("Bisan", new User("Bisan", "0000", "bisan@gmail.com", Type.beneficiaryUser));
	        users.put("Bisan_joo", new User("Bisan_joo", "password123", "bisan_joo@gmail.com", Type.beneficiaryUser));
	        admins.put("ahmad", new User("ahmad", "0000", "ahmad@gmail.com", Type.admin));
	        owners.put("ali", new User("ali", "0000", "ali@gmail.com", Type.storeowner));
	        rawSuppliers.put("sami", new User("sami", "0000", "sami@gmail.com", Type.rawmaterialsupplier));
	        users.put("amal", new User("amal", "0000", "amal@gmail.com", Type.beneficiaryUser));
	        rawSuppliers.put("amjad", new User("amjad", "0000", "amjad@gmail.com", Type.rawmaterialsupplier));
	        owners.put("saden", new User("saden", "0000", "saden@gmail.com", Type.storeowner));
	        admins.put("Ruba", new User("Ruba", "0000", "Ruba@gmail.com", Type.admin));
	        owners.put("alia", new User("alia", "0000", "alia@gmail.com", Type.storeowner));
	        products.put("1", new Product(1, "cake",2.5 ,150));
	        products.put("2", new Product(2, "tarte", 6.0 ,146));
	        products.put("3", new Product(3, "kunafa",10.5 ,189));
	        allRecipe.put("Cake", new Recipe("Cake", "diet", "Mix flour, sugar, and eggs", users.get("Bisan")));
	        allRecipe.put("cake with coffee", new Recipe("cake with coffee", "suger free", "Mix ingredients", users.get("Bisan_joo")));
	        allRecipe.put("cake with milk", new Recipe("cake with milk", "Glutien free", "Mix ingredientsr", users.get("amal")));
	        admins.put("Bisan M Joudeh", new User("Bisan M Joudeh", "0000", "Bisan12@gmail.com",Type.admin));
	        messages.put("bisan@gmail.com",new Message("bisan@gmail.com","ali@gmail.com","Hello"));
	        rawSuppliers.put("salwa", new User("salwa", "0000", "salwa@gmailk55RTU.com", Type.rawmaterialsupplier));
	        allMaterials.put("1", new Material(1, "flour", 2.5, 150));
	        allMaterials.put("2", new Material(2, "sugar", 6.0, 203)); 
	        allMaterials.put("3", new Material(3, "butter", 10.5, 96));
	        allMaterials.put("4", new Material(4, "cocoa powder", 8.0, 150));

	        isRegistered = !users.isEmpty() || !admins.isEmpty() || !owners.isEmpty() || !rawSuppliers.isEmpty();
	    }

	        
	        public void addMaterial(Material m) {
				boolean existmaterial=false;
				for (HashMap.Entry<String, Material> entry : allMaterials.entrySet()) {
		        	Material mm = entry.getValue();
		        	if(mm.getName().equals(m.getName()))
		        		existmaterial=true;
		        	else if(mm.getMaterialId()==m.getMaterialId()) {
		        		System.out.println("Sorry,This number of the new material exist , try another number");
		        	return;}
		        }
				if(getMaterial(m.getName())==null && !existmaterial) {
					if(m.getMaterialId()!=0  && m.getName()!="" && m.getPrice()!=0.0 && m.getQuantityavailable()!=0)
				{String x=String.valueOf(m.getMaterialId());
				allMaterials.put(x, m);
				System.out.println("Adding new material successfully done");}
					else
						System.out.println("Sorry , you miss important details");}
				else
					System.out.println("This material already exist");

			}

	        public void removeMaterial(String materialName) {
		        /*if (allMaterials.containsKey(materialName)) {
		            allMaterials.remove(materialName);
		            System.out.println("Material removed: " + materialName);
		        } else {
		            System.out.println("Material not found: " + materialName);
		        }*/
	        	
	        	for (Material material : allMaterials.values()) {
	        		if(material.getName().equals(materialName)) {
	        			allMaterials.remove(String.valueOf(material.getMaterialId()));
		            System.out.println("Material removed: " + materialName);
		            return;}
	        	}
	            System.out.println("Material not found: " + materialName);

	        	
		    }

	        
	        public static Map<String, Material> getAllMaterials() {
				return allMaterials;
			}

			public static void setAllMaterials(Map<String, Material> allMaterials) {
				myappsweet.allMaterials = allMaterials;
			}

			public Material getMaterial(String MaterialName) {
		        return allMaterials.get(MaterialName);
		    }

	    public void addFeedbackToRecipe(String recipeName, String feedbackContent) {
	        User user = getactiveuser();
	       Recipe  recipe = getRecipe(recipeName);

	        if (user == null) {
	            System.out.println("You must be logged in to add feedback.");
	            return;
	        }

	        if (recipe == null) {
	            System.out.println("Recipe not found. Feedback cannot be added.");
	            return;
	        }

	        if (feedbackContent == null || feedbackContent.trim().isEmpty()) {
	            System.out.println("Feedback cannot be empty.");
	            return;
	        }

	        Feedback feedback = new Feedback(feedbackContent, user, recipe);
	        recipe.addFeedback(feedback);
	        System.out.println("Feedback added successfully.");
	    }

	    
	    public void filterRecipe(String keyword) {
	        filteredrecipes.clear(); 

	        for (Recipe recipe : allRecipe.values()) {
	            if (recipe.getDetails() != null && recipe.getDetails().toLowerCase().contains(keyword.toLowerCase())) {
	                filteredrecipes.add(recipe);
	            }
	        }
	        if(filteredrecipes.isEmpty())
	        System.out.println("Sorry No Result");
	        else {
		        System.out.println("This is the result:");
		        for (Recipe recipe : filteredrecipes) {
		            System.out.println(recipe);
		        }}
	       
	    }

	    public List<Recipe> getFilteredRecipes() {
	        return new ArrayList<Recipe>(filteredrecipes);
	    }

    
	    public boolean userExists(String username) {
	        return users.containsKey(username) || admins.containsKey(username) || owners.containsKey(username) || rawSuppliers.containsKey(username);
	    }

	    public boolean authenticate(String username, String password) {
	        User user = getUser(username);
	        return user != null && user.getPassword().equals(password);
	    }

	    public boolean authenticateEmail(String username, String email) {
	        User user = getUser(username);
	        return user != null && user.getEmail().equals(email);
	    }

	    public void addUser(User user) {
	        switch (user.getKindofuser()) {
	            case beneficiaryUser:
	                users.put(user.getUsername(), user);
	                break;
	            case admin:
	                admins.put(user.getUsername(), user);
	                break;
	            case storeowner:
	                owners.put(user.getUsername(), user);
	                break;
	            case rawmaterialsupplier:
	                rawSuppliers.put(user.getUsername(), user);
	                break;
	        }
	    }

	    public User getUser(String username) {
	        User user = users.get(username);
	        if (user == null) {
	            user = admins.get(username);
	        }
	        if (user == null) {
	            user = owners.get(username);
	        }
	        if (user == null) {
	            user = rawSuppliers.get(username);
	        }
	        return user;
	    }

	    public Map<String, User> getUsers() {
	        return users;
	    }

	    public Map<String, User> getAdmins() {
	        return admins;
	    }

	    public static Map<String, User> getOwners() {
	        return owners;
	    }

	    public Map<String, User> getRawSuppliers() {
	        return rawSuppliers;
	    }
	    
	    public User getactiveuser()

	    {
	    	return this.activeuser;
	    }
	    
	    public void setactiveuser(User activeuser) {
	        this.activeuser =activeuser;
	        islogged = activeuser != null;
	    }
	    
	    
	    public void addRecipe(Recipe recipe) {
	        boolean existrecipe=false;
	        
	        for (HashMap.Entry<String, Recipe> entry : allRecipe.entrySet()) {
	        	Recipe mm = entry.getValue();
	        	if(mm.getRecipeName().equals(recipe.getRecipeName()))
	        		existrecipe=true;
	        }
	        
			if ( recipe.getRecipeName() != null && !existrecipe) {
	            allRecipe.put(recipe.getRecipeName(), recipe);
	            System.out.println("Recipe added: " + recipe.getRecipeName());
	        } else {
	            System.out.println("recipe or recipe name cannot be null or it is exist already");
	        }
	    }

	    
	    public Recipe getRecipe(String recipeName) {
	        return allRecipe.get(recipeName);
	    }
	    
	    
	    public Recipe getRecipefromdetails(String details) {
	        for (Recipe recipe : allRecipe.values()) {
	            if (recipe.getDetails().equals(details)) {
	                return recipe;
	            }
	        }
	        return null; 
	    }
    
	    public void removeRecipe(String recipeName) {
	        if (allRecipe.containsKey(recipeName)) {
	            allRecipe.remove(recipeName);
	            System.out.println("Recipe removed: " + recipeName);
	        } else {
	            System.out.println("Recipe not found: " + recipeName);
	        }
	    }
	    	    
	    public String removeuser(String username) {
	        if (users.containsKey(username)) {
	            users.remove(username);
	            return "User has been successfully deleted";
	        } else if (rawSuppliers.containsKey(username)) {
	            rawSuppliers.remove(username);
	            return "Raw material supplier has been successfully deleted";
	        } else if (owners.containsKey(username)) {
	            owners.remove(username);
	            return "Store owner has been successfully deleted";
	        } else {
	            return "This User does not exist";
	        }
	    }

	    
	    public void removesupplier(String sname) {
	        if (rawSuppliers.containsKey(sname)) {
	            rawSuppliers.remove(sname);
	            System.out.println("Raw Supplier removed: " + sname);
	        } else {
	            System.out.println("Raw Supplier not found: " + sname);
	        }
	    }
	    
	      
	    public void removeowner(String oname) {
	        if (owners.containsKey(oname)) {
	            owners.remove(oname);
	            System.out.println("Owner removed: " + oname);
	        } else {
	            System.out.println("Owner not found: " + oname);
	        }
	    }
	    
	    public Recipe searchRecipe(String recipeName) {
	        return allRecipe.get(recipeName);
	    }

	       
	   
	    public Map<String, Recipe> getAllRecipes() {
	        return allRecipe;
	    }

	    
    
	    public static  Map<String, Product> getProducts() {
			return products;
		}



  



 
  


	public boolean IsThereAproductInStore() {
		myappsweet a=new myappsweet() ;
		if(a.getProducts().isEmpty())
			return false;
		else
			return true;
		
		
	}

	public void GenerateReport() {
		 for (Sales r : Sales.sales.values()) {
	            System.out.println(r.getName() +"  "+r.getSale());
	        }
		 if(Sales.sales.isEmpty())
			 System.out.println("There is no sales");
	}
  String b;
	public String BestProduct() {
		   int x=0;
		 for (Sales r : Sales.sales.values()) {
		   if(r.getSale()>x) {
			   x=r.getSale();
		       b=r.getName();}
		 }	
		 return b;
	}

	public boolean IsThereAUserInStore() {
		// TODO Auto-generated method stub
		if(users.isEmpty())
		return false;
		else
			return true;
	}

 
 
	public boolean ViewMessageSetToMe(String string) {
		myappsweet a = new myappsweet();
        for (Message obj : myappsweet.messages.values()) {
            // Safely compare strings using Objects.equals
            if (Objects.equals(obj.getTo(), string)) {
                System.out.println("There is a message for you");
                System.out.println(obj.getContent());
                return true;
            }
        }
        return false;
	}

    
	
	public String updateRecipe(String recipeName,String details,String instructions) {
		Recipe recipe=allRecipe.get(recipeName);
		if(recipe==null) {
			return"Recipenotfound";
		}
		if(!recipe.getSharedBy().equals(activeuser)) {
			return"You can not update a recipe that does not belong to you";
		}
		
		if(details==null || details.isEmpty() || instructions==null || instructions.isEmpty() )
		{return "Recipe details and instructions are required";}
		
		recipe.setDetails(details);
		recipe.setInstructions(instructions);
		return"Recipe update successfully";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

	    private void signup(Scanner scanner) {
	        System.out.println("\nSign Up");
	        System.out.print("Enter username: ");
	        String username = scanner.nextLine();
	        System.out.print("Enter password: ");
	        String password = scanner.nextLine();
	        System.out.print("Enter email: ");
	        String email = scanner.nextLine();

	        if (userExists(username)) {
	            System.out.println("Registration failed. Username '" + username + "' already exists.");
	        } else {
	            System.out.println("Select user type:");
	            System.out.println("1. Beneficiary User");
	            System.out.println("2. Admin");
	            System.out.println("3. Store Owner");
	            System.out.println("4. Raw Material Supplier");
	            System.out.print("Choose an option: ");
	            int userTypeChoice = scanner.nextInt();
	            scanner.nextLine();

	            Type userType;
	            switch (userTypeChoice) {
	                case 1:
	                    userType = Type.beneficiaryUser;
	                    break;
	                case 2:
	                    userType = Type.admin;
	                    break;
	                case 3:
	                    userType = Type.storeowner;
	                    break;
	                case 4:
	                    userType = Type.rawmaterialsupplier;
	                    break;
	                default:
	                    System.out.println("Invalid option. Defaulting to Beneficiary User.");
	                    userType = Type.beneficiaryUser;
	            }

	            User newUser = new User(username, password, email, userType);
	            addUser(newUser);
	            System.out.println("Registration successful!");
	        }
	    }

	   
	    private void login(Scanner scanner) {
	        System.out.println("\nLog In");
	        System.out.print("Enter username: ");
	        String username = scanner.nextLine();
	        System.out.print("Enter password: ");
	        String password = scanner.nextLine();

	        if (authenticate(username, password)) {
	            activeuser = getUser(username);
	            islogged = true;
	            System.out.println("Login successful. Welcome " + getUserTypeName(activeuser.getKindofuser()) + " " + username);
	        } else {
	            System.out.println("Login failed. Incorrect username or password.");
	        }
	    }

	   
	    private void logout(Scanner scanner) {
	        System.out.println("\nLog Out");
	        if (!islogged) {
	            System.out.println("You cannot log out. Please log in first.");
	        } else {
	            System.out.print("Are you sure you want to log out? (yes/no) ");
	            String confirmation = scanner.nextLine();
	            if (confirmation.equalsIgnoreCase("yes")) {
	                activeuser = null;
	                islogged = false;
	                System.out.println("You have successfully logged out.");
	            } else {
	                System.out.println("Logout canceled.");
	            }
	        }
	    }

	  
	    private String getUserTypeName(Type type) {
	        switch (type) {
	            case beneficiaryUser:
	                return "user";
	            case admin:
	                return "admin";
	            case storeowner:
	                return "owner";
	            case rawmaterialsupplier:
	                return "Raw Material Supplier";
	            default:
	                return "unknown";
	        }
	    }

	    
	    
	    
	    
	    
	    
	   
	    private void addRecipe(Scanner scanner) {
	        System.out.println("Add a new recipe");
	        System.out.print("Enter recipe name: ");
	        String recipeName = scanner.nextLine();
	        System.out.print("Enter recipe details: ");
	        String details = scanner.nextLine();
	        System.out.print("Enter recipe instructions: ");
	        String instructions = scanner.nextLine();

	        Recipe recipe = new Recipe(recipeName, details, instructions, activeuser);
	        addRecipe(recipe);
	       
	    }

	 
	    public void viewAllRecipes() {
	        System.out.println("Displaying all recipes...");
	        for (Recipe recipe : allRecipe.values()) {
	            System.out.println(recipe);
	        }
	    }

	   
	    private void deleteRecipe(Scanner scanner) {
	        System.out.println("Delete a recipe");
	        System.out.print("Enter recipe name to delete: ");
	        String recipeName = scanner.nextLine();

	        Recipe recipe = getRecipe(recipeName);
	        if (recipe != null && recipe.getSharedBy().equals(activeuser)) {
	            removeRecipe(recipeName);
	            System.out.println("Recipe deleted: " + recipeName);
	        } else if(recipe==null) {
	            System.out.println("Recipe not found.");
	        }
	        else {
	        	System.out.println("You can not delete a recipe that does not belong to you");
	        }
	    }

	 
        
    }
    


