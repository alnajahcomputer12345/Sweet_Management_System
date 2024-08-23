package myAPP2024;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.List;
import java.util.*;
import java.util.logging.Logger;
import java.util.logging.Level;

public class myappsweet {



	boolean pricefill=false;
    private static final Logger logger = Logger.getLogger(myappsweet.class.getName());

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
			   logger.log(Level.INFO, "You are in the add new product");
			
		}
        
		public boolean checkifexist(String string) {
			for (Product obj : products.values()) {
			    String productName = obj.getNameOfProduct();
			    if (productName != null && productName.equals(string)) {
			        return true;
			    }
			}
			return false;	}
		
		
		public void checkifpricefill(Product p) {
			if(p.getPrice()==0.0)
				  logger.log(Level.INFO, "You missing an important details");
			else
				pricefill=true;
		}

		public void printerrormessage() {
			  logger.log(Level.INFO, "You can not add this product you missing an important details");
			
		}


		public boolean checkifexisttoremove(Product p) {
			for (Product obj : products.values()) {
		        // Check if obj and p are not null, and their attributes are also not null
		        if (obj.getNumProduct() == p.getNumProduct() && 
		            obj.getNameOfProduct() != null && 
		            obj.getNameOfProduct().equals(p.getNameOfProduct())) {
		            logger.log(Level.INFO, "This product exists");
		            return true;
		        }
		    }
		    logger.log(Level.INFO, "This product does not exist");
		    return false;
		}

		public void RemoveProduct(Product p) {
			if(EnterAllRequieredToDelete(p)) {
            if(checkifexisttoremove(p)) {
			products.remove(String.valueOf(p.getNumProduct()));
			  logger.log(Level.INFO, "Remove done successfully");

            }
            
            else
          	  logger.log(Level.INFO, "This product not exist");
			}
			else
				 logger.log(Level.INFO, "Sorry ,You miss an important details");
			
		}

		public void printproductnotexist() {
			logger.log(Level.INFO, "This product not exist");
				}

		public boolean EnterAllRequieredToDelete(Product p) {
			// TODO Auto-generated method stub
			if(p.getNameOfProduct()!=" " && p.getNumProduct()!=0)
				return true;
			else {
				if(p.getNameOfProduct()==" ") {
					
				
					forgettenfield= "product name";}
					else 
						forgettenfield= "product number";
		
				logger.log(Level.INFO, "You may forget to enter an important detail: " + forgettenfield);
				}
				return false;
		
			}


		
		public void addnewProduct(Product p) {
			
			String x=String.valueOf(p.getNumProduct());
			boolean b=false;
	        for (HashMap.Entry<String, Product> entry : products.entrySet()) {
	        	Product product = entry.getValue();
	        	if(product.getNumProduct()==p.getNumProduct())
	        		b=true;
	        }
			 		
			if(checkifexist(p.getNameOfProduct()) || b) {
				logger.log(Level.INFO, "The product is exist OR check your datat well");
				
				return;
			}
			else {
				checkifpricefill(p);
				if(pricefill && p. getNumProduct()!=0 &&p.getNameOfProduct()!="" && p.getCount()!=0) {
					products.put(x, p);
					logger.log(Level.INFO, "Adding Product Successfully");
				
					}
			
			else
				logger.log(Level.INFO, "Sorry check the data you entered , there is a missing data");}
			
			for (HashMap.Entry<String, Product> entry : products.entrySet()) {
	        	Product product = entry.getValue();
	        	System.out.println(product);
	        }
		
		
		
		}
				
	


public void printDone() {
	logger.log(Level.INFO, "Adding Done");
	
}

public void viewlistofproducts() {
	
	 for (String key : products.keySet()) {
		 logger.log(Level.INFO, "Key: " + key + ", Value: " + products.get(key));
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
	        users.put("Bisan", new User("Bisan", "0000", "bisan@gmail.com", Type.BENEFICIARY_USER));
	        users.put("Bisan_joo", new User("Bisan_joo", "password123", "bisan_joo@gmail.com", Type.BENEFICIARY_USER));
	        admins.put("ahmad", new User("ahmad", "0000", "ahmad@gmail.com", Type.ADMIN));
	        owners.put("ali", new User("ali", "0000", "ali@gmail.com", Type.STORE_OWNER));
	        rawSuppliers.put("sami", new User("sami", "0000", "sami@gmail.com", Type.RAW_MATERIAL_SUPPLIER));
	        users.put("amal", new User("amal", "0000", "amal@gmail.com", Type.BENEFICIARY_USER));
	        rawSuppliers.put("amjad", new User("amjad", "0000", "amjad@gmail.com", Type.RAW_MATERIAL_SUPPLIER));
	        owners.put("saden", new User("saden", "0000", "saden@gmail.com", Type.STORE_OWNER));
	        admins.put("Ruba", new User("Ruba", "0000", "Ruba@gmail.com", Type.ADMIN));
	        owners.put("alia", new User("alia", "0000", "alia@gmail.com", Type.STORE_OWNER));
	        products.put("1", new Product(1,"cake",2.5 ,150));
	        products.put("2", new Product(2, "tarte", 6.0 ,146));
	        products.put("3", new Product(3, "kunafa",10.5 ,189));
	        allRecipe.put("Cake", new Recipe("Cake", "diet", "Mix flour, sugar, and eggs", users.get("Bisan")));
	        allRecipe.put("cake with coffee", new Recipe("cake with coffee", "suger free", "Mix ingredients", users.get("Bisan_joo")));
	        allRecipe.put("cake with milk", new Recipe("cake with milk", "Glutien free", "Mix ingredientsr", users.get("amal")));
	        admins.put("Bisan M Joudeh", new User("Bisan M Joudeh", "0000", "Bisan12@gmail.com",Type.ADMIN));
	        messages.put("bisan@gmail.com",new Message("bisan@gmail.com","ali@gmail.com","Hello"));
	        rawSuppliers.put("salwa", new User("salwa", "0000", "salwa@gmailk55RTU.com", Type.RAW_MATERIAL_SUPPLIER));
	        allMaterials.put("1", new Material(1, "flour", 2.5, 150));
	        allMaterials.put("2", new Material(2, "sugar", 6.0, 203)); 
	        allMaterials.put("3", new Material(3, "butter", 10.5, 96));
	        allMaterials.put("4", new Material(4, "cocoa powder", 8.0, 150));

	        isRegistered = !users.isEmpty() || !admins.isEmpty() || !owners.isEmpty() || !rawSuppliers.isEmpty();
	    }
public boolean addmaterial=false;
	       
	        public boolean isAddmaterial() {
	return addmaterial;
}

public void setAddmaterial(boolean addmaterial) {
	this.addmaterial = addmaterial;
}

			public void addMaterial(Material m) {
				boolean existmaterial=false;
				for (HashMap.Entry<String, Material> entry : allMaterials.entrySet()) {
		        	Material mm = entry.getValue();
		        	if(mm.getName().equals(m.getName()))
		        		existmaterial=true;
		        	else if(mm.getMaterialId()==m.getMaterialId()) {
		        		logger.log(Level.INFO, "Sorry,This number of the new material exist , try another number");
		        	return;}
		        }
				if(getMaterial(m.getName())==null && !existmaterial) {
					if(m.getMaterialId()!=0  && m.getName()!="" && m.getPrice()!=0.0 && m.getQuantityavailable()!=0)
				{String x=String.valueOf(m.getMaterialId());
				allMaterials.put(x, m);
				addmaterial=true;
				logger.log(Level.INFO, "Adding new material successfully done");
				}
					else
						logger.log(Level.INFO, "Sorry , you miss important details");
				}
				else
					logger.log(Level.INFO, "This material already exist");
				

			}


	        public void removeMaterial(String materialName) {
		      	        	
	        	for (Material material : allMaterials.values()) {
	        		if(material.getName().equals(materialName)) {
	        			allMaterials.remove(String.valueOf(material.getMaterialId()));
	        			logger.log(Level.INFO, "Material removed: " + materialName);
		            return;}
	        	}
	        	logger.log(Level.INFO, "Material not found: " + materialName);

	        	
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
		        	logger.log(Level.INFO, "You must be logged in to add feedback.");
		            return;
		        }

		        if (recipe == null) {
		        	logger.log(Level.INFO, "Recipe not found. Feedback cannot be added.");
		            return;
		        }

		        if (feedbackContent == null || feedbackContent.trim().isEmpty()) {
		        	logger.log(Level.INFO, "Feedback cannot be empty.");
		            return;
		        }

		        Feedback feedback = new Feedback(feedbackContent, user, recipe);
		        recipe.addFeedback(feedback);
		    	logger.log(Level.INFO, "Feedback added successfully.");
		    }

	    
			public void filterRecipe(String keyword) {
		        filteredrecipes.clear(); 

		        for (Recipe recipe : allRecipe.values()) {
		            if (recipe.getDetails() != null && recipe.getDetails().toLowerCase().contains(keyword.toLowerCase())) {
		                filteredrecipes.add(recipe);
		            }
		        }
		        if(filteredrecipes.isEmpty())
		        	logger.log(Level.INFO, "Sorry No Result");
		        else {
		        	logger.log(Level.INFO, "This is the result:");
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
public boolean adduser=false;

	    public boolean isAdduser() {
	return adduser;
}

public void setAdduser(boolean adduser) {
	this.adduser = adduser;
}

		public void addUser(User user) {
	        switch (user.getKindofuser()) {
	            case BENEFICIARY_USER:
	                users.put(user.getUsername(), user);
	                break;
	            case ADMIN:
	                admins.put(user.getUsername(), user);
	                break;
	            case STORE_OWNER:
	                owners.put(user.getUsername(), user);
	                break;
	            case RAW_MATERIAL_SUPPLIER:
	                rawSuppliers.put(user.getUsername(), user);
	                break;
	        }
	        adduser=true;
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
	    
	    public boolean addrecipe=false;
	    
	    public boolean isAddrecipe() {
			return addrecipe;
		}

		public void setAddrecipe(boolean addrecipe) {
			this.addrecipe = addrecipe;
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
	            logger.log(Level.INFO, "Recipe added: " + recipe.getRecipeName());
	            addrecipe=true;
	        } else {
	        	 logger.log(Level.INFO, "recipe or recipe name cannot be null or it is exist already");
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
	            logger.log(Level.INFO, "Recipe removed: " + recipeName);
	        } else {
	        	logger.log(Level.INFO, "Recipe not found: " + recipeName);
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
	            logger.log(Level.INFO, "Raw Supplier removed: " + sname);
	        } else {
	        	   logger.log(Level.INFO, "Raw Supplier not found: " + sname);
	        }
	    }
	    
	      
	    public void removeowner(String oname) {
	        if (owners.containsKey(oname)) {
	            owners.remove(oname);
	            logger.log(Level.INFO, "Owner removed: " + oname);
	        } else {
	        	 logger.log(Level.INFO, "Owner not found: " + oname);
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
				 logger.log(Level.INFO, r.getName() +"  "+r.getSale());
		        }
			 if(Sales.sales.isEmpty())
				 logger.log(Level.INFO, "There is no sales");
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
        	  logger.log(Level.INFO,"There is a message for you");
         	 logger.log(Level.INFO,obj.getContent());

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
	
	
 
	
	    public void signup(Scanner scanner) {
	    	logger.log(Level.INFO, "\nSign Up");
	        logger.log(Level.INFO, "Enter username: ");
	        String username = scanner.nextLine();
	        logger.log(Level.INFO, "Enter password: ");
	        String password = scanner.nextLine();
	        logger.log(Level.INFO, "Enter email: ");
	        String email = scanner.nextLine();

	        if (userExists(username)) {
	            logger.log(Level.WARNING, "Registration failed. Username '" + username + "' already exists.");
	        } else {
	            logger.log(Level.INFO, "Select user type:");
	            logger.log(Level.INFO, "1. Beneficiary User");
	            logger.log(Level.INFO, "2. Admin");
	            logger.log(Level.INFO, "3. Store Owner");
	            logger.log(Level.INFO, "4. Raw Material Supplier");
	            logger.log(Level.INFO, "Choose an option: ");
	            int userTypeChoice = scanner.nextInt();
	            scanner.nextLine();

	            Type userType;
	            switch (userTypeChoice) {
	                case 1:
	                    userType = Type.BENEFICIARY_USER;
	                    break;
	                case 2:
	                    userType = Type. ADMIN;
	                    break;
	                case 3:
	                    userType = Type.STORE_OWNER;
	                    break;
	                case 4:
	                    userType = Type.RAW_MATERIAL_SUPPLIER;
	                    break;
	                default:
	                    logger.log(Level.WARNING, "Invalid option. Defaulting to Beneficiary User.");
	                    userType = Type.BENEFICIARY_USER;
	            }

	            User newUser = new User(username, password, email, userType);
	            addUser(newUser);
	            logger.log(Level.INFO, "Registration successful!");
	        }

	    }

	   
	    public void login(Scanner scanner) {
	    	 logger.log(Level.INFO, "\nLog In");
		        logger.log(Level.INFO, "Enter username: ");
		        String username = scanner.nextLine();
		        logger.log(Level.INFO, "Enter password: ");
		        String password = scanner.nextLine();

		        if (authenticate(username, password)) {
		            activeuser = getUser(username);
		            islogged = true;
		            logger.log(Level.INFO, "Login successful. Welcome {0} {1}", 
		                       new Object[]{getUserTypeName(activeuser.getKindofuser()), username});
		        } else {
		            logger.log(Level.WARNING, "Login failed. Incorrect username or password.");
		        }

	    }

	   
	    public void logout(Scanner scanner) {
	    	logger.log(Level.INFO, "\nLog Out");
	        if (!islogged) {
	            logger.log(Level.WARNING, "You cannot log out. Please log in first.");
	        } else {
	            logger.log(Level.INFO, "Are you sure you want to log out? (yes/no) ");
	            String confirmation = scanner.nextLine();
	            if (confirmation.equalsIgnoreCase("yes")) {
	                activeuser = null;
	                islogged = false;
	                logger.log(Level.INFO, "You have successfully logged out.");
	            } else {
	                logger.log(Level.INFO, "Logout canceled.");
	            }

	        }
	    }

	  
	    public String getUserTypeName(Type type) {
	        switch (type) {
	            case BENEFICIARY_USER:
	                return "user";
	            case ADMIN:
	                return "admin";
	            case STORE_OWNER:
	                return "owner";
	            case RAW_MATERIAL_SUPPLIER:
	                return "Raw Material Supplier";
	            default:
	                return "unknown";
	        }
	    }

	    
	    
	    
	    
	    
	    
	   
	    private void addRecipe(Scanner scanner) {
	    	logger.log(Level.INFO, "Add a new recipe");
	        logger.log(Level.INFO, "Enter recipe name: ");
	        String recipeName = scanner.nextLine();
	        logger.log(Level.INFO, "Enter recipe details: ");
	        String details = scanner.nextLine();
	        logger.log(Level.INFO, "Enter recipe instructions: ");
	        String instructions = scanner.nextLine();

	        Recipe recipe = new Recipe(recipeName, details, instructions, activeuser);
	        addRecipe(recipe);
	        logger.log(Level.INFO, "Recipe added successfully", recipeName);
	       
	    }

	 
	    public void viewAllRecipes() {
	    	logger.log(Level.INFO, "Displaying all recipes...");
	        for (Recipe recipe : allRecipe.values()) {
	            logger.log(Level.INFO, recipe.toString());
	        }

	    }

	   
	    private void deleteRecipe(Scanner scanner) {
	        logger.log(Level.INFO, "Delete a recipe");
	        logger.log(Level.INFO, "Enter recipe name to delete: ");
	        String recipeName = scanner.nextLine();

	        Recipe recipe = getRecipe(recipeName);
	        if (recipe != null && recipe.getSharedBy().equals(activeuser)) {
	            removeRecipe(recipeName);
	            logger.log(Level.INFO, "Recipe deleted: {0}", recipeName);
	        } else if (recipe == null) {
	            logger.log(Level.WARNING, "Recipe not found: {0}", recipeName);
	        } else {
	            logger.log(Level.WARNING, "You cannot delete a recipe that does not belong to you: {0}", recipeName);
	        }
	    }
	 
        
	 
        
    }
    


