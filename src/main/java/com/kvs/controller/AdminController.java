package com.kvs.controller;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kvs.entity.Brand;
import com.kvs.entity.Category;
import com.kvs.entity.Godown;
import com.kvs.entity.OfflineCounter;
import com.kvs.entity.OnlineCounter;
import com.kvs.entity.Order;
import com.kvs.entity.OrderedProducts;
import com.kvs.entity.Product;
import com.kvs.entity.Sale;
import com.kvs.entity.SoldProducts;
import com.kvs.entity.Supply;
import com.kvs.entity.SupplyId;
import com.kvs.entity.User;
import com.kvs.entity.Vendor;
import com.kvs.service.BrandService;
import com.kvs.service.CategoryService;
import com.kvs.service.CounterService;
import com.kvs.service.CustomerService;
import com.kvs.service.GodownService;
import com.kvs.service.OrderService;
import com.kvs.service.ProductService;
import com.kvs.service.SaleService;
import com.kvs.service.StaffService;
import com.kvs.service.SupplyService;
import com.kvs.service.UserService;
import com.kvs.service.VendorService;
import com.kvs.user.CrmUser;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	//inject service classes
	
	@Autowired
	private VendorService vendorService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private BrandService brandService;
	
	@Autowired
	private ProductService productService;
	
	 @Autowired
	 private UserService userService;
	 
	 @Autowired
	 private StaffService staffService;
	 
	 @Autowired
	 private CustomerService custService;
	 
	 @Autowired
	 private OrderService orderService;
	 
	 @Autowired
	 private SaleService saleService;
	 
	 @Autowired
	 private CounterService counterService;
	 
	 @Autowired
	 private GodownService godownService;
	 
	 @Autowired
	 private SupplyService supplyService;
	
	@GetMapping("/addCustomer")
	public String showaddCustform(Model theModel) {
		
		//create model attribute to bind form data
		User theCustomer = new User();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "addstaffForm";
		
	}
	
	
	@GetMapping("/viewCustomer")
	public String showviewCust(Model theModel) {
		
				//get staffs from service layer
				List<User> theCusts = custService.getCustomers();
								
				//add attribute to the model
				theModel.addAttribute("customers", theCusts);
								
				return "viewCustomer";
		
	}
	
	@GetMapping("/addStaff")
	public String showaddStaffform(Model theModel) {
		
		//create model attribute to bind form data
		CrmUser theStaff = new CrmUser();
				
		theModel.addAttribute("staff", theStaff);
		
		return "addstaffForm";
		
	}
	
	@PostMapping("/saveStaff")
	public String saveStaff(@Valid @ModelAttribute("staff") CrmUser theStaff, 
			BindingResult theBindingResult, Model theModel) {
		
		String email = theStaff.getEmail();
		//logger.info("Processing registration form for: " + email);
		
		// form validation
		 if (theBindingResult.hasErrors()){
			 return "addstaffForm";
	        }

		// check the database if user already exists
        User existing = userService.findByEmail(email);
        
        if (existing != null){
        	theModel.addAttribute("staff", new CrmUser());
			theModel.addAttribute("registrationError", "Email already exists.");

			//logger.warning("Email already exists.");
        	return "addstaffForm";
        }
     // create user account        						
        userService.saveStaff(theStaff);
        
        //logger.info("Successfully created user: " + email);
        
        User registered = userService.findByEmail(email);
        
        theModel.addAttribute("userid", registered.getUserName());
        
        return "registration-confirmation";		
		
	}
		
	
	@GetMapping("/viewStaff")
	public String showviewStaff(Model theModel) {
		
		//get staffs from service layer
		List<User> theStaffs = staffService.getStaffs();
						
		//add attribute to the model
		theModel.addAttribute("staffs", theStaffs);
						
		return "viewStaff";
		
	}
	
	@GetMapping("/addVendor")
	public String showaddVendorform(Model theModel) {
		
		//create model attribute to bind form data
			Vendor theVendor = new Vendor();
						
			theModel.addAttribute("vendor", theVendor);
				
			return "addVendorForm";
		
	}
	
	@PostMapping("/saveVendor")
	public String saveVendor(@Valid @ModelAttribute("vendor") Vendor theVendor,
								BindingResult theBindingResult) {
		
		// form validation
		if (theBindingResult.hasErrors()){
				 return "addVendorForm";
		}
		
		//save the vendor using our service
		 vendorService.saveVendor(theVendor);
				
		return "redirect:/login_home";
		
	}
	
	
	@GetMapping("/viewVendor")
	public String showviewVendor(Model theModel) {
		
		//get vendors from service layer
		List<Vendor> theVendors = vendorService.getVendors();
				
		//add the categories to the model
		theModel.addAttribute("vendors", theVendors);
				
		return "viewVendor2";
	}
		
		@GetMapping("/showFormForUpdateVendor")
		public String showFormForUpdateVendor(@RequestParam("vendorId") int theId,
												Model theModel) {
			
			//get the vendor from database
			Vendor theVendor = vendorService.getVendor(theId);
					
			//set vendor as a model attribute to pre-populate the form
			theModel.addAttribute("vendor", theVendor);
			
			//send over to our form
					
			return "addVendorForm";
		
	}
		
		@GetMapping("/addSupply")
		public String addSupply(@RequestParam("vendorId") int vendorID, Model theModel) {
			
			Vendor theVendor = vendorService.getVendor(vendorID);
			theModel.addAttribute("vendor",theVendor);
			
			return "addSupplyForm";
		}
		
		@PostMapping("/saveSupply")
		public String saveSupply(@RequestParam("batchNo") int batchNo,
								  @RequestParam("productId") int productId,
								  @RequestParam("quantity") int quantity,
								  @RequestParam("supplyDate") Date supplyDate,
								  @RequestParam("expiryDate") Date expiryDate,
								  @RequestParam("vendorId") int vendorId) {

				Product theProduct = productService.getProduct(productId);
				Vendor theVendor = vendorService.getVendor(vendorId);
				
				SupplyId primaryKey = new SupplyId(batchNo, theProduct, theVendor);
				
				Supply theSupply = new Supply(primaryKey, quantity, supplyDate, expiryDate);
				//save the product using our service
				supplyService.saveSupply(theSupply);
				
				theProduct.setStock(theProduct.getStock() + quantity);
				productService.saveProduct(theProduct);
	
				return "redirect:/admin/viewVendor";
		}
		
		@GetMapping("/viewSupply")
		public String viewSupply(@RequestParam("vendorId") int theId,
												Model theModel) {
			
			//get the vendor
			Vendor theVendor = vendorService.getVendor(theId);
			List<Supply> theSupplies = supplyService.getSupplybyVendor(theVendor);
			
			theModel.addAttribute("supplies",theSupplies);
			
			return "viewSupply";
			
		
	}
		
		@GetMapping("/deleteVendor")
		public String deleteVendor(@RequestParam("vendorId") int theId,
												Model theModel) {
			
			//delete the vendor
			vendorService.deleteVendor(theId);
			
			return "redirect:/admin/viewVendor";
			
		
	}
		
		@GetMapping("/addCategory")
		public String showaddCatform(Model theModel) {
			
			//create model attribute to bind form data
			Category theCategory = new Category();
			
			theModel.addAttribute("category", theCategory);
			
			return "addCatForm";
			
		}
		
		@PostMapping("/saveCategory")
		public String saveCategory(@Valid @ModelAttribute("category") Category theCategory,
									BindingResult theBindingResult) {
			
			// form validation
			if (theBindingResult.hasErrors()){
					 return "addCatForm";
			}
			
			//save the vendor using our service
			 categoryService.saveCategory(theCategory);
					
			return "redirect:/login_home";
			
		}
		
		@GetMapping("/viewCats")
		public String viewCategories(Model theModel) {
			
			//create model attribute to bind form data
			List<Category> categories = categoryService.getCategories();
			
			theModel.addAttribute("categories", categories);
			
			return "viewCats";
			
		}
		
		@GetMapping("/addBrand")
		public String showaddBrandform(Model theModel) {
			
			//create model attribute to bind form data
			Brand theBrand = new Brand();
			
			theModel.addAttribute("brand", theBrand);
			
			return "addBrandForm";
			
		}
		
		@PostMapping("/saveBrand")
		public String saveBrand(@Valid @ModelAttribute("brand") Brand theBrand,
									BindingResult theBindingResult) {
			
			// form validation
			if (theBindingResult.hasErrors()){
					 return "addBrandForm";
			}
			
			//save the vendor using our service
			brandService.saveBrand(theBrand);
					
			return "redirect:/login_home";
			
		}
		
		@GetMapping("/viewBrands")
		public String viewBrands(Model theModel) {
			
			//create model attribute to bind form data
			List<Brand> brands = brandService.getBrands();
			
			theModel.addAttribute("brands", brands);
			
			return "viewBrands";
			
		}
		
		@GetMapping("/addProduct")
		public String showaddProductform(Model theModel) {
			
			//create model attribute to bind form data
			//Product theProduct = new Product();
			List<Category> theCategories = categoryService.getCategories();
			List<Brand> theBrands = brandService.getBrands();
			List<Godown> godowns = godownService.getGodowns();
			
			//theModel.addAttribute("product", theProduct);
			theModel.addAttribute("categories", theCategories);
			theModel.addAttribute("brands", theBrands);
			theModel.addAttribute("godowns", godowns);
			
			return "addProductForm";
			
		}
		
		@PostMapping("/saveProduct")
		public String saveProduct(@RequestParam("productName") String name,
								  @RequestParam("productDes") String desc,
								  @RequestParam("category") String cat,
								  @RequestParam("brand") String brand,
								  @RequestParam("MRP") String mrp,
								  @RequestParam("quantity") int quantity,
								  @RequestParam("godown") int godownId){
			
			Category theCategory=categoryService.getCategorybyName(cat);
			Brand theBrand=brandService.getBrandbyName(brand);
			Godown theGodown = godownService.getGodown(godownId);
			
			Product theProduct=new Product(name, desc, theCategory, theBrand, mrp, quantity, theGodown);
			//save the product using our service
			productService.saveProduct(theProduct);
					
			return "redirect:/admin/viewProducts";
			
		}
		
		@GetMapping("/updateProduct")
		public String updateProduct(@RequestParam("productId") int theId, Model theModel) {
			
			//create model attribute to bind form data
			Product theProduct = productService.getProduct(theId);
			
			
			theModel.addAttribute("product", theProduct);
			
			
			return "updateProductForm";
			
		}
		
		@PostMapping("/updateProductProcess")
		public String updateProductProcess(@ModelAttribute("product") Product theProduct, 
											@RequestParam("category1") String cat,
											@RequestParam("brand1") String brand,
											@RequestParam("godown1"
													+ "") int godownId, Model theModel) {
			
			Category theCategory=categoryService.getCategorybyName(cat);
			Brand theBrand=brandService.getBrandbyName(brand);
			Godown theGodown = godownService.getGodown(godownId);
			
			theProduct.setCategory(theCategory);
			theProduct.setBrand(theBrand);
			theProduct.setGodown(theGodown);
			
			productService.saveProduct(theProduct);
			
			return "redirect:/admin/viewProducts";
			
		}
		
		@GetMapping("/viewProducts")
		public String showProducts(Model theModel) {
			
			//get vendors from service layer
			List<Product> products = productService.getProducts();
					
			//add the categories to the model
			theModel.addAttribute("products", products);
					
			return "viewProducts";
		}
		
		@GetMapping("/viewUnprocessedOrders")
		public String showUnprocessedOrders(Model theModel) {
			
			//get vendors from service layer
			List<Order> theOrders = orderService.getOrdersByStatus("Not Processed");
					
			//add the categories to the model
			theModel.addAttribute("orders", theOrders);
					
			return "viewUnprocessedOrders";
		}
		
		@GetMapping("/viewProcessingOrders")
		public String showProcessingOrders(Model theModel) {
			
			//get vendors from service layer
			List<Order> theOrders = orderService.getOrdersByStatus("Processing");
					
			//add the categories to the model
			theModel.addAttribute("orders", theOrders);
					
			return "viewProcessingOrders";
		}
		
		@GetMapping("/viewProcessedOrders")
		public String showProcessedOrders(Model theModel) {
			
			//get vendors from service layer
			List<Order> theOrders = orderService.getOrdersByStatus("Processed");
					
			//add the categories to the model
			theModel.addAttribute("orders", theOrders);
					
			return "viewProcessedOrders";
		}
		
		@GetMapping("/viewProductsInOrder")
		public String showOrderProductDetails(@RequestParam("orderId") String orderID, Model theModel){
			
			//get the order_id
			Integer theid=Integer.parseInt(orderID);
			int orderId=theid.intValue();
					
			//get the order
			Order theOrder = orderService.getTheOrder(orderId);
			
			//get ordered products
			List<OrderedProducts> orderProducts =orderService.getOrderedProducts(theOrder);
			
			theModel.addAttribute("products", orderProducts);
			
			return "viewProductsInOrder2";
		}
		
		@GetMapping("/addOnlineCounter")
		public String addOnlineCounter(Model theModel) {
			
			//create model attribute to bind form data
			OnlineCounter theCounter = new OnlineCounter();
			
			//save the vendor using our service
			counterService.saveOnlineCounter(theCounter);
					
			return "redirect:/login_home";
			
		}
		
		@GetMapping("/addOfflineCounter")
		public String addOfflineCounter(Model theModel) {
			
			//create model attribute to bind form data
			OfflineCounter theCounter = new OfflineCounter();
			
			//save the vendor using our service
			counterService.saveOfflineCounter(theCounter);
					
			return "redirect:/login_home";
			
		}
		
		@GetMapping("/viewOnlineCounters")
		public String viewOnlineCounter(Model theModel) {
			
			//create model attribute to bind form data
			List<OnlineCounter> theCounters = counterService.getOnlineCounters();
			
			theModel.addAttribute("counters", theCounters);
					
			return "viewOnlineCounters";
			
		}
		
		@GetMapping("/viewOfflineCounters")
		public String viewOfflineCounter(Model theModel) {
			
			//create model attribute to bind form data
			List<OfflineCounter> theCounters = counterService.getOfflineCounters();
			
			theModel.addAttribute("counters", theCounters);
					
			return "viewOfflineCounters";
			
		}
		
		@GetMapping("/assignOnlineCounter")
		public String assignOnlineCounter(@RequestParam("orderId") String orderID, Model theModel) {
			
			//create model attribute to bind form data
			
			List<OnlineCounter> theCounters = counterService.getOnlineCounters();
			//List<Brand> theBrands = brandService.getBrands();
			
			//theModel.addAttribute("product", theProduct);
			theModel.addAttribute("counters", theCounters);
			theModel.addAttribute("orderID", orderID);
			
			return "assignOnlineCounterForm";
			
		}
		
		
		
		@PostMapping("/updateOrderCounter")
		public String updateOrderCounter(@RequestParam("orderId") String orderID,
								  @RequestParam("counter") String counterID){
			
			Integer theid=Integer.parseInt(orderID);
			int orderId=theid.intValue();
			
			Integer theCounterid=Integer.parseInt(counterID);
			int counterId=theCounterid.intValue();
			
			Order theOrder=orderService.getOrder(orderId);
			
			OnlineCounter theCounter=counterService.getOnlineCounter(counterId);
			
			theOrder.setCounter(theCounter);
			theOrder.setStatus("Processing");
			
			//update the order using our service
			orderService.updateOrder(theOrder);
					
			return "redirect:/admin/viewUnprocessedOrders";
			
		}
		
		@GetMapping("/allotOnlineCounter")
		public String allotOnlineCounter(@RequestParam("staffId") String staffID, Model theModel) {
			
			//create model attribute to bind form data
			
			List<OnlineCounter> theCounters = counterService.getOnlineCounters();
			//List<Brand> theBrands = brandService.getBrands();
			
			//theModel.addAttribute("product", theProduct);
			theModel.addAttribute("counters", theCounters);
			theModel.addAttribute("staffID", staffID);
			
			return "staffOnlineCounterAllotForm";
			
		}
		
		@PostMapping("/processOnlineCounterAllotment")
		public String processOnlineCounterAllotment(@RequestParam("staffId") String staffID,
								  @RequestParam("counter") String counterID){
			
			Integer theid=Integer.parseInt(staffID);
			int staffId=theid.intValue();
			
			Integer theCounterid=Integer.parseInt(counterID);
			int counterId=theCounterid.intValue();
			
			User theStaff=userService.findByUserName(staffId);
			
			OnlineCounter theCounter=counterService.getOnlineCounter(counterId);
			
			theStaff.setOnlineCounter(theCounter);
			
			
			//update the order using our service
			userService.updateStaff(theStaff);
					
			return "redirect:/admin/viewStaff";
			
		}
		
		@GetMapping("/allotOfflineCounter")
		public String allotOfflineCounter(@RequestParam("staffId") String staffID, Model theModel) {
			
			//create model attribute to bind form data
			
			List<OfflineCounter> theCounters = counterService.getOfflineCounters();
			//List<Brand> theBrands = brandService.getBrands();
			
			//theModel.addAttribute("product", theProduct);
			theModel.addAttribute("counters", theCounters);
			theModel.addAttribute("staffID", staffID);
			
			return "staffOfflineCounterAllotForm";
			
		}
		
		@PostMapping("/processOfflineCounterAllotment")
		public String processOfflineCounterAllotment(@RequestParam("staffId") String staffID,
								  @RequestParam("counter") String counterID){
			
			Integer theid=Integer.parseInt(staffID);
			int staffId=theid.intValue();
			
			Integer theCounterid=Integer.parseInt(counterID);
			int counterId=theCounterid.intValue();
			
			User theStaff=userService.findByUserName(staffId);
			
			OfflineCounter theCounter=counterService.getOfflineCounter(counterId);
			
			theStaff.setOfflineCounter(theCounter);
			
			
			//update the order using our service
			userService.updateStaff(theStaff);
					
			return "redirect:/admin/viewStaff";
			
		}
		
		@GetMapping("/showFormForUpdateStaff")
		public String showFormForUpdateStaff(@RequestParam("staffId") int theId,
												Model theModel) {
			
			//get the staff from database
			User theStaff=userService.findByUserName(theId);
			
			CrmUser staff = new CrmUser();
			
			staff.setFirstName(theStaff.getFirstName());
			staff.setMiddleName(theStaff.getMiddleName());
			staff.setLastName(theStaff.getLastName());
			
			staff.setEmail(theStaff.getEmail());
			
			staff.setStreet(theStaff.getStreet());
			staff.setCity(theStaff.getCity());
			staff.setPin(theStaff.getPin());
			staff.setState(theStaff.getState());
					
			//set vendor as a model attribute to pre-populate the form
			theModel.addAttribute("staff", staff);
			
			//send over to our form
					
			return "updateStaffForm";
		
	}
		
		@PostMapping("/updateStaff")
		public String updateStaff(@Valid @ModelAttribute("staff") CrmUser theStaff, 
				BindingResult theBindingResult, Model theModel) {
			
			String email = theStaff.getEmail();
			//logger.info("Processing registration form for: " + email);
			
			// form validation
			 if (theBindingResult.hasErrors()){
				 return "updateStaffForm";
		        }

			// check the database if user already exists
	        User existing = userService.findByEmail(email);
	        
	        if (existing != null){
	        	
	        	existing.setPassword(passwordEncoder.encode(theStaff.getPassword()));
	        	existing.setFirstName(theStaff.getFirstName());
	        	existing.setMiddleName(theStaff.getMiddleName());
	        	existing.setLastName(theStaff.getLastName());
	    		//user.setEmail(crmUser.getEmail());
	        	existing.setStreet(theStaff.getStreet());
	        	existing.setCity(theStaff.getCity());
	        	existing.setPin(theStaff.getPin());
	        	existing.setState(theStaff.getState());
	    		

	    		// give user default role of "employee"
	    		//user.setRoles(Arrays.asList(roleDao.findRoleByName("ROLE_CUSTOMER")));

	    		 // save user in the database
	        	userService.updateStaff(existing);

				//logger.warning("Email already exists.");
	        	return "redirect:/admin/viewStaff";
	        }
	        
	        return "updateStaffForm";
	        
		}
		
		@GetMapping("/addGodown")
		public String showaddGodownform(Model theModel) {
			
			//create model attribute to bind form data
			Godown theGodown = new Godown();
			
			theModel.addAttribute("godown", theGodown);
			
			return "addGodownForm";
			
		}
		
		@PostMapping("/saveGodown")
		public String saveGodown(@ModelAttribute("godown") Godown theGodown,
								@RequestParam("inchargeId") int inchargeID) {
			
			
			User incharge = userService.findByUserName(inchargeID);
			
			theGodown.setIncharge(incharge);
			//save the godown using our service
			godownService.saveGodown(theGodown);
					
			return "redirect:/admin/viewGodown";
			
		}
		
		@GetMapping("/viewGodown")
		public String viewGodown(Model theModel) {
			
			//System.out.println("Hi----1");
			//get godowns from service layer
			List<Godown> theGodowns = godownService.getGodowns();
			//System.out.println("Hi----2");	
			//add the godowns to the model
			theModel.addAttribute("godowns", theGodowns);
			//System.out.println("Hi----3");
					
			return "viewGodown";
		}
		
		
		@GetMapping("/showFormForUpdateGodown")
		public String showFormForUpdateGodown(@RequestParam("godownId") int godownID, Model theModel) {
			
			Godown theGodown = godownService.getGodown(godownID);
			theModel.addAttribute("godown",theGodown);
			
			return "addGodownForm";
		}
		
		@GetMapping("/viewSales")
		public String showOfflineSales(Model theModel) {
			
			//get vendors from service layer
			List<Sale> theSales = saleService.getAllSales();
					
			//add the categories to the model
			theModel.addAttribute("sales", theSales);
					
			return "viewSales";
		}
		@GetMapping("/viewProductsInSale")
		public String showSoldProductDetails(@RequestParam("saleId") String saleID, Model theModel){
			
			//get the order_id
			Integer theid=Integer.parseInt(saleID);
			int saleId=theid.intValue();
					
			//get the order
			Sale theSale = saleService.getTheSale(saleId);
			
			//get ordered products
			List<SoldProducts> soldProducts = saleService.getSoldProducts(theSale);
			
			theModel.addAttribute("products", soldProducts);
			
			return "viewProductsInSale2";
		}
		
		
		

}
