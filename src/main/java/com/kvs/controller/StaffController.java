package com.kvs.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kvs.entity.EPayment;
import com.kvs.entity.OfflineCounter;
import com.kvs.entity.OnlineCounter;
import com.kvs.entity.Order;
import com.kvs.entity.OrderedProducts;
import com.kvs.entity.OrderedProductsId;
import com.kvs.entity.Product;
import com.kvs.entity.ProductWithTotal;
import com.kvs.entity.ProductsInCart;
import com.kvs.entity.ProductsInCartId;
import com.kvs.entity.Sale;
import com.kvs.entity.SoldProducts;
import com.kvs.entity.SoldProductsId;
import com.kvs.entity.User;
import com.kvs.service.BrandService;
import com.kvs.service.CartService;
import com.kvs.service.CategoryService;
import com.kvs.service.CounterService;
import com.kvs.service.CustomerService;
import com.kvs.service.OrderService;
import com.kvs.service.PaymentService;
import com.kvs.service.ProductService;
import com.kvs.service.SaleService;
import com.kvs.service.StaffService;
import com.kvs.service.UserService;
import com.kvs.service.VendorService;

@Controller
@RequestMapping("/staff")
public class StaffController {
	
		//inject vendor service class
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
		private CartService cartService;
		
		 @Autowired
		private PaymentService paymentService;
	
		 @GetMapping("/viewProcessingOrders")
		 public String showProcessingOrders(Authentication authentication, Model theModel) {
				
			 	//get the staff_id
				String id= authentication.getName();
				//System.out.println(id);
				Integer sid=Integer.parseInt(id);
				int staff_id=sid.intValue();
				
				//get the user with staff_id as id
				User staff = userService.findByUserName(staff_id);
				
				OnlineCounter counter = staff.getOnlineCounter();
				//get vendors from service layer
				List<Order> theOrders = orderService.getOrdersByCounterAndStatus(counter,"Processing");
						
				//add the categories to the model
				theModel.addAttribute("orders", theOrders);
						
				return "viewProcessingOrders2staff";
			}
		 
		 @GetMapping("/viewProcessedOrders")
		 public String showProcessedOrders(Authentication authentication, Model theModel) {
				
			 	//get the staff_id
				String id= authentication.getName();
				//System.out.println(id);
				Integer sid=Integer.parseInt(id);
				int staff_id=sid.intValue();
				
				//get the user with staff_id as id
				User staff = userService.findByUserName(staff_id);
				
				OnlineCounter counter = staff.getOnlineCounter();
				//get vendors from service layer
				List<Order> theOrders = orderService.getOrdersByCounterAndStatus(counter,"Processed");
						
				//add the categories to the model
				theModel.addAttribute("orders", theOrders);
						
				return "viewProcessedOrders2staff";
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
				
				return "viewProductsInOrder2staff";
			}
		 	
		 	@GetMapping("/processOrder")
			public String assignOnlineCounter(@RequestParam("orderId") String orderID,Authentication authentication, Model theModel) {
				
		 		Integer theid=Integer.parseInt(orderID);
				int orderId=theid.intValue();
				
				Order theOrder=orderService.getOrder(orderId);
				
				//OnlineCounter theCounter=counterService.getOnlineCounter(counterId);
				List<OrderedProducts> orderedProducts = orderService.getOrderedProducts(theOrder);
				
				int check = 1;
				
				for(OrderedProducts op: orderedProducts) {
					if(op.getProduct().getStock() < op.getQuantity())
						check=0;
				}
				
				if(check==1) {
					//theOrder.setCounter(theCounter);
					
					for(OrderedProducts op: orderedProducts) {
						int newStock= op.getProduct().getStock() - op.getQuantity();
						op.getProduct().setStock(newStock);
						productService.saveProduct(op.getProduct());
					}
				theOrder.setStatus("Processed");
				
				//update the order using our service
				orderService.updateOrder(theOrder);
				
				//get the staff_id
				String id= authentication.getName();
				//System.out.println(id);
				Integer sid=Integer.parseInt(id);
				int staff_id=sid.intValue();
				
				//get the user with staff_id as id
				User staff = userService.findByUserName(staff_id);
				
				OnlineCounter counter = staffService.getOnlineCounter(staff_id);
				counter.setTotalSale(counter.getTotalSale() + theOrder.getTotalAmount());
				counterService.saveOnlineCounter(counter);
						
				return "redirect:/staff/viewProcessingOrders";
				}
				
				else {return "outofstockWarning";}
			}
		 	
		 	//_____________________OFFLINE SALE ADDED____________________
		 	
		 	@GetMapping("/viewProducts")
			public String listProducts(@RequestParam("categoryId") int categoryId,
										Model theModel){
				
				//get categories from dao
				List<Product> theProducts = productService.findProductByCatAndQty(categoryId);;
				
				//add the categories to the model
				theModel.addAttribute("products", theProducts);
				
				return "viewProductstoStaff";
				
			}
			
			@GetMapping("/addtocart")
			public String addProductToCart(@RequestParam("productId") int theId,
													Model theModel, Authentication authentication) {
				
				
				//get categories from service
				//List<Category> theCategories = categoryService.getCategories();
				
				//get the product from database
				Product theProduct = productService.getProduct(theId);
				//System.out.println(theProduct);
				
				//get the staff_id
				String id= authentication.getName();
				//System.out.println(id);
				Integer sid=Integer.parseInt(id);
				int staff_id=sid.intValue();
				
				//get the user with customer_id as id
				User staff = userService.findByUserName(staff_id);
				
				//generate the primary key
				ProductsInCartId primarykey= new ProductsInCartId(staff, theProduct);
				
				ProductsInCart existing=cartService.findProductInCart(staff, theProduct);
				
				if(existing==null) {
				//create new product in cart object
				ProductsInCart productInCart=new ProductsInCart(primarykey, 1);
				
				cartService.saveCart(productInCart);
				}
				
				else {
					
					int quantity=existing.getQuantity();
					//System.out.println("HEEEEllll");
					ProductsInCart productInCart=new ProductsInCart(primarykey, quantity+1);
					
					cartService.saveCart(productInCart);
				}
				
				//set vendor as a model attribute to pre-populate the form
				theModel.addAttribute("product", theProduct);
				
				//send over to our form
						
				return "redirect:/staff/viewCart";
			
			}
			
			@GetMapping("/viewCart")
			public String showCart(Authentication authentication, Model theModel){
				
				//get the staff_id
				String id= authentication.getName();
				Integer sid=Integer.parseInt(id);
				int staff_id=sid.intValue();
						
				//get the user with customer_id as id
				User staff = userService.findByUserName(staff_id);
				
				//get cart products
				//List<Product> theProducts =cartService.getProductsInCart(customer);
				List<ProductsInCart> cartProducts =cartService.getCartProducts(staff);
				
				List<ProductWithTotal> tp = new ArrayList<ProductWithTotal>();
				
				int sum=0;
				
				for(ProductsInCart p : cartProducts) {
					int total = (p.getQuantity())*((Integer.parseInt(p.getProduct().getMRP())));
					ProductWithTotal t = new ProductWithTotal(p,total);
					tp.add(t);
				}
				
				for(ProductWithTotal pt : tp) {
					int price = pt.getTotal();
					sum=sum+price;
				}
				
				//add the categories to the model
				//theModel.addAttribute("products", theProducts);
				theModel.addAttribute("products", tp);
				theModel.addAttribute("total", sum);
				
				return "sales_cart";
				
			}
			
			@GetMapping("/removeFromCart")
			public String removeFromCart(@RequestParam("productId") int theId,
											Model theModel, Authentication authentication){
				
						//get the product from database
						Product theProduct = productService.getProduct(theId);
						//System.out.println(theProduct);
						
						//get the customer_id
						String id= authentication.getName();
						//System.out.println(id);
						Integer cid=Integer.parseInt(id);
						int staff_id=cid.intValue();
						
						//get the user with customer_id as id
						User staff = userService.findByUserName(staff_id);
						
						//generate the primary key
						ProductsInCartId primarykey= new ProductsInCartId(staff, theProduct);
						
						cartService.removeProduct(primarykey);
								
						return "redirect:/staff/viewCart";
				
			}
			
			@GetMapping("/increaseQty")
			public String increaseQty(@RequestParam("productId") int theId, Authentication authentication, Model theModel){
				
						
						//get the product from database
						Product theProduct = productService.getProduct(theId);
						//System.out.println(theProduct);
						
						//get the customer_id
						String id= authentication.getName();
						//System.out.println(id);
						Integer cid=Integer.parseInt(id);
						int staff_id=cid.intValue();
						
						//get the user with customer_id as id
						User staff = userService.findByUserName(staff_id);
						
						//generate the primary key
						ProductsInCartId primarykey= new ProductsInCartId(staff, theProduct);
						
						ProductsInCart existing=cartService.findProductInCart(staff, theProduct);
						
						int quantity=existing.getQuantity();
						
						ProductsInCart productInCart=new ProductsInCart(primarykey, quantity+1);
						
						cartService.saveCart(productInCart);
				
						return "redirect:/staff/viewCart";
				
			}
			
			@GetMapping("/decreaseQty")
			public String decreaseQty(@RequestParam("productId") int theId, Authentication authentication, Model theModel){
				
						
						//get the product from database
						Product theProduct = productService.getProduct(theId);
						//System.out.println(theProduct);
						
						//get the customer_id
						String id= authentication.getName();
						//System.out.println(id);
						Integer cid=Integer.parseInt(id);
						int staff_id=cid.intValue();
						
						//get the user with customer_id as id
						User staff = userService.findByUserName(staff_id);
						
						//generate the primary key
						ProductsInCartId primarykey= new ProductsInCartId(staff, theProduct);
						
						ProductsInCart existing=cartService.findProductInCart(staff, theProduct);
						
						int quantity=existing.getQuantity();
						
						ProductsInCart productInCart=new ProductsInCart(primarykey, quantity-1);
						
						cartService.saveCart(productInCart);
				
						return "redirect:/staff/viewCart";
				
			}
			
			//PROCESSING SALE
			
			@GetMapping("/toPayment")
			public String viewPaymentsPage(Authentication authentication, Model theModel){
				
				//get the customer_id
				String id= authentication.getName();
				Integer cid=Integer.parseInt(id);
				int staff_id=cid.intValue();
						
				//get the user with customer_id as id
				User staff = userService.findByUserName(staff_id);
				
				//get cart products
				//List<Product> theProducts =cartService.getProductsInCart(customer);
				List<ProductsInCart> cartProducts =cartService.getCartProducts(staff);
				
				List<ProductWithTotal> tp = new ArrayList<ProductWithTotal>();
				
				int sum=0;
				
				for(ProductsInCart p : cartProducts) {
					int total = (p.getQuantity())*((Integer.parseInt(p.getProduct().getMRP())));
					ProductWithTotal t = new ProductWithTotal(p,total);
					tp.add(t);
				}
				
				for(ProductWithTotal pt : tp) {
					int price = pt.getTotal();
					sum=sum+price;
				}
				
				if ( sum > 0){
				//add the categories to the model
				//theModel.addAttribute("products", theProducts);
				theModel.addAttribute("products", tp);
				theModel.addAttribute("total", sum);
				
				return "checkoutStaff";
				}
				
				else {return "redirect:/staff/viewCart";}
				
			}
			
			@PostMapping("/processSale")
			public String processPayment(@RequestParam("payment_method") String method, 
										 @RequestParam("customerId") String customerID, Authentication authentication, Model theModel){
				
				
				//get the staff_id
				String id= authentication.getName();
				Integer sid=Integer.parseInt(id);
				int staff_id=sid.intValue();
						
				//get the user with staff_id as id
				User staff = userService.findByUserName(staff_id);
				
				//get cart products
				//List<Product> theProducts =cartService.getProductsInCart(customer);
				List<ProductsInCart> cartProducts =cartService.getCartProducts(staff);
				
				//_______Get the Customer to whom this is sold to_______________
				
				//get the customer_id
				Integer cid=Integer.parseInt(customerID);
				int customer_id=cid.intValue();
						
				//get the user with staff_id as id
				User customer = userService.findByUserName(customer_id);
				
				//______________________________________________________________
				
				int sum=0;
				
				for(ProductsInCart p : cartProducts) {
					int total = (p.getQuantity())*((Integer.parseInt(p.getProduct().getMRP())));
					sum=sum+total;
					//ProductWithTotal t = new ProductWithTotal(p,total);
					//tp.add(t);
				}
				int check = 1;
				
				for(ProductsInCart cp: cartProducts) {
					if(cp.getProduct().getStock() < cp.getQuantity())
						check=0;
				}
				
				if(check==1) {
					
				String str ="cod"; 
				
				//if cod is payment method
				 if(method.equals(str)) {
					 
						//Date today = new Date();
						long millis = System.currentTimeMillis();
						java.sql.Date today = new java.sql.Date(millis);
						OfflineCounter counter = staffService.getOfflineCounter(staff_id);
						
						Sale theSale = new Sale("Successfully sold", today, "Cash On Delivery", sum, customer, counter);
						int saleId = saleService.saveSale(theSale);
						
						Sale saleDone=saleService.getSale(saleId);
						
						for(ProductsInCart p : cartProducts) {
							
							SoldProductsId key = new SoldProductsId(saleDone, p.getProduct());
									
							SoldProducts soldProduct = new SoldProducts(key, p.getQuantity()); 
							
							saleService.saveSoldProducts(soldProduct);
							
							int newStock= p.getProduct().getStock() - p.getQuantity();
							
							p.getProduct().setStock(newStock);
							
							productService.saveProduct(p.getProduct());
							
						}
						
						cartService.deleteCartProducts(staff);
						
						
						counter.setTotalSale(counter.getTotalSale() + theSale.getTotalAmount());
						counterService.saveOfflineCounter(counter);
						
						theModel.addAttribute("total", sum);
						
						return "sale_confirmation";
					 
				 } 
				 
				//if online payment is payment method
				 else {
					 
					 	//Date today = new Date();
						long millis = System.currentTimeMillis();
						java.sql.Date today = new java.sql.Date(millis);
						
						OfflineCounter counter = staffService.getOfflineCounter(staff_id);
						
						Sale theSale = new Sale("Successfully sold", today, "Online Payment", sum, customer, counter);
						
						int saleId = saleService.saveSale(theSale);
						
						Sale saleDone=saleService.getSale(saleId);
						
						for(ProductsInCart p : cartProducts) {
							
							SoldProductsId key = new SoldProductsId(saleDone, p.getProduct());
									
							SoldProducts soldProduct = new SoldProducts(key, p.getQuantity()); 
							
							saleService.saveSoldProducts(soldProduct);
							
							int newStock= p.getProduct().getStock() - p.getQuantity();
							
							p.getProduct().setStock(newStock);
							
							productService.saveProduct(p.getProduct());
							
						}
						
						cartService.deleteCartProducts(staff);
						
						EPayment thePayment = new EPayment(sum, today, "Successfully paid", saleDone);
						
						paymentService.savePayment(thePayment);
						
						//OfflineCounter counter = staffService.getOfflineCounter(staff_id);
						counter.setTotalSale(counter.getTotalSale() + theSale.getTotalAmount());
						counterService.saveOfflineCounter(counter);
						
						theModel.addAttribute("total", sum);
						
						return "sale_confirmation";
				
				 }
				}
				else {return "outofstockWarning";}
				
			}
			
			//_____________________OFFLINE SALE COMPLETED____________________
			
}
