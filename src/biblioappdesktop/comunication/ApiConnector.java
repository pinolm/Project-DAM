/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioappdesktop.comunication;

import biblioappdesktop.main.App;
import biblioappdesktop.mappers.*;
import biblioappdesktop.mappers.UserPost;
import biblioappdesktop.request.LoginRequest;
import biblioappdesktop.response.LoginResponse;
import biblioappdesktop.response.UserUpdateResponse;
import biblioappdesktop.windows.login.Window_LOGIN_ALL;
import biblioappdesktop.windows.admin.Window_MAIN_administrator;
import biblioappdesktop.windows.user.Window_MAIN_user;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


/**
 *
 * @author Cristian
 */
public class ApiConnector {
    
    //CONST URL MAIN
    private static final String URL = "https://biblioappioc2021.herokuapp.com";
    //CONST LOGIN
    private static final String URL_auth = URL + "/auth/login";
    //CONST USER
    private static final String URL_postUser = URL + "/auth/registrarUsuari";
    private static final String URL_updatetUser = URL + "/auth/actualitzarUsuari/";
    private static final String URL_deletetUser = URL + "/auth/eliminarUsuari/";
    private static final String URL_getUsers = URL + "/auth/llistaUsuaris";
    //CONST BOOKS
    private static final String URL_addBook = URL + "/llibre/crearLlibre";
    private static final String URL_updateBook = URL + "/llibre/actualizarLlibre/";
    private static final String URL_deleteBook = URL + "/llibre/eliminarLlibre/";
    private static final String URL_getbooks = URL + "/llibre/llistaLlibres";
    //CONST PRESTESCS
    private static final String URL_addprestec = URL + "/prestec/crearPrestec";
    private static final String URL_updatePrestec = URL + "/prestec/actualizarPrestec/";
    private static final String URL_deletePrestec = URL + "/prestec/eliminarPrestec/";
    private static final String URL_getprestecs = URL + "/prestec/llistaPrestecs";
    //CONST AUTORS
    private static final String URL_addAutor = URL + "/autor/crearAutor";
    private static final String URL_updateAutor = URL + "/autor/actualizarAutor/";
    private static final String URL_deleteAutor = URL + "/autor/eliminarAutor/";
    private static final String URL_getAutors = URL + "/autor/llistaAutors";
    //CONST CATEGORIES
    private static final String URL_addCategoria = URL + "/categoria/crearCategoria";
    private static final String URL_updateCategoria = URL + "/categoria/actualizarCategoria/";
    private static final String URL_deleteCategoria = URL + "/categoria/eliminarCategoria/";
    private static final String URL_getCategories = URL + "/categoria/llistaCategories";
    
    /**
     *
     * @param username
     * @param pass
     * 
     * This method help to the auth user
     * 
     * @return token if is succes, otherwise return null
     */   
    public static String authenticate(String username, String pass) {
                    
        Window_MAIN_administrator mainAdmin = new Window_MAIN_administrator();
        Window_MAIN_user mainUser = new Window_MAIN_user();
        App app = new App();
       
                         
        try {
            LoginRequest body = new LoginRequest();
            body.setUsername(username);
            body.setPassword(pass);
            HttpRequest request = HttpRequest.newBuilder().uri(new URI(URL_auth))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(new Gson().toJson(body))).build();

            HttpResponse<String> response = HttpClient.newBuilder().build().send(request,
                    HttpResponse.BodyHandlers.ofString());
           
            switch (response.statusCode()) {
                case (200):
                    Gson g = new Gson();
                    LoginResponse p = g.fromJson(response.body(), LoginResponse.class);
                    System.out.println("The token is " + p.getToken());
                    System.out.println("Connexió entre client-servidor OK - CODI 200");
                    Collection rols;

                    rols = p.getAuthorities();
                    String rolee = rols.toString();
                    
                    String rlss = rols.iterator().toString();

                    if (rolee.equalsIgnoreCase("[{authority=ROLE_ADMIN}, {authority=ROLE_USER}]")) {
                        mainAdmin.setVisible(true);                       
                    } else if (rolee.equalsIgnoreCase("[{authority=ROLE_USER}]")) {
                        mainUser.setVisible(true);                       
                    } else {
                        System.out.println("cap dels dos");                       
                    }
                    
                    return p.getToken();
                                       
                case (400):
                    System.out.println(response.body());
                    return null;
                case (500):
                    System.out.println("server error:" + response.body());
                    return null;
            }

        } catch (Exception e) {
            System.out.println("There was an error");
            System.out.println(e.getMessage());
            return null;
        }
        return null;
    }
    
    
    /**
     *
     * @param token
     * @param userpost
     * 
     * This method create a new user
     * 
     * @return message with successful confirmation or otherwise a null
     * 
     */
    public static Missatge createUser(String token, UserPost userpost) {
        
		try {
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(URL_postUser))
					.header("Content-Type", "application/json").setHeader("Authorization", "Bearer" + token)
					.POST(HttpRequest.BodyPublishers.ofString(new Gson().toJson(userpost))).build();
			HttpResponse<String> response = HttpClient.newBuilder().build().send(request,
					HttpResponse.BodyHandlers.ofString());

			System.out.println(response.statusCode());
			System.out.println(response.body());
			switch (response.statusCode()) {
			case (201):
				Gson g = new Gson();
				return g.fromJson(response.body(), Missatge.class);
			default:
				return null;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
  
    /**
     *
     * @param token
     * @param _id
     * @param userupdate
     * 
     * This method updates a user from an id passed through the url
     * 
     * @return username or otherwise a null
     * 
     */
    public static String updateUser(String token, String _id, UserUpdate userupdate) {
        
		try {
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(URL_updatetUser + _id))
					.header("Content-Type", "application/json").setHeader("Authorization", "Bearer" + token)
					.PUT(HttpRequest.BodyPublishers.ofString(new Gson().toJson(userupdate))).build();
			HttpResponse<String> response = HttpClient.newBuilder().build().send(request,
					HttpResponse.BodyHandlers.ofString());

			System.out.println(response.statusCode());
			System.out.println(response.body());
			switch (response.statusCode()) {
			case (200):                            
				Gson g = new Gson();
				return g.fromJson(response.body(), UserUpdateResponse.class).getNomUsuari();
			default:
				return null;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    } 
    
    /**
     *
     * @param token
     * @param userId
     * 
     * This method removes an existing user
     * 
     * @return message with successful confirmation or otherwise a null
     * 
     */
    public static Missatge deleteUsers(String token, String userId) {
       
		try {
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(URL_deletetUser + userId))
					.header("Content-Type", "application/json").setHeader("Authorization", "Bearer " + token).DELETE()
					.build();
			HttpResponse<String> response = HttpClient.newBuilder().build().send(request,
					HttpResponse.BodyHandlers.ofString());

			System.out.println(response.statusCode());
			System.out.println(response.body());
			switch (response.statusCode()) {
			case (200):
				Gson g = new Gson();
				return g.fromJson(response.body(), Missatge.class); 
                                
			default:
				return null;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

    }
    
    /**
     * @param token
     * 
     * @return List with users
     */
    public static List<Users> getUsers(String token) {
        
		try {
			System.out.println(URL_getUsers);
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(URL_getUsers))
					.header("Content-Type", "application/json").setHeader("Authorization", " Bearer " + token).GET()
					.build();
			HttpResponse<String> response = HttpClient.newBuilder().build().send(request,
					HttpResponse.BodyHandlers.ofString());

			System.out.println(response.statusCode());

			switch (response.statusCode()) {
			case (200):
				Gson g = new Gson();
				Users[] p = g.fromJson(response.body(), Users[].class);
				return Arrays.asList(p);
			default:
				return null;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
    
   
   /**
     *
     * @param token
     * @param addbook
     * 
     * This method create a new book
     * 
     * @return message with successful confirmation or otherwise a null
     * 
     */
   public static Missatge addBook(String token, AddBook addbook) {
        
		try {
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(URL_addBook))
					.header("Content-Type", "application/json").setHeader("Authorization", "Bearer " + token)
					.POST(HttpRequest.BodyPublishers.ofString(new Gson().toJson(addbook))).build();
			HttpResponse<String> response = HttpClient.newBuilder().build().send(request,
					HttpResponse.BodyHandlers.ofString());

			System.out.println(response.statusCode());
			System.out.println(response.body());
			switch (response.statusCode()) {
			case (200):
				Gson g = new Gson();
				return g.fromJson(response.body(), Missatge.class);
			default:
				return null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
   
    /**
     *
     * @param token
     * @param _id
     * @param updateBook
     * 
     * This method updates a book from an id passed through the url
     * 
     * @return message with successful confirmation or otherwise a null
     * 
     */
   public static Missatge updateBook(String token, String _id, BookUpdate updatebook) {
        
		try {
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(URL_updateBook+ _id))
					.header("Content-Type", "application/json").setHeader("Authorization", "Bearer " + token)
					.PUT(HttpRequest.BodyPublishers.ofString(new Gson().toJson(updatebook))).build();
			HttpResponse<String> response = HttpClient.newBuilder().build().send(request,
					HttpResponse.BodyHandlers.ofString());

			System.out.println(response.statusCode());
			System.out.println(response.body());
			switch (response.statusCode()) {
			case (200):
				Gson g = new Gson();
				return g.fromJson(response.body(), Missatge.class);
			default:
				return null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }

    /**
     *
     * @param token
     * @param bookId
     * 
     * This method removes an existing book
     * 
     * @return message with successful confirmation or otherwise a null
     * 
     */
    public static Missatge deleteBook(String token, String bookId) {
       
		try {
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(URL_deleteBook + bookId))
					.header("Content-Type", "application/json").setHeader("Authorization", "Bearer " + token).DELETE()
					.build();
			HttpResponse<String> response = HttpClient.newBuilder().build().send(request,
					HttpResponse.BodyHandlers.ofString());

			System.out.println(response.statusCode());
			System.out.println(response.body());
			switch (response.statusCode()) {
			case (200):
				Gson g = new Gson();
				return g.fromJson(response.body(), Missatge.class); 
			default:
				return null;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
   
     /**
     * @param token
     * 
     * @return List with books
     */
    public static List<BooksList> getBooks(String token) {
        
		try {
			System.out.println(URL_getbooks);
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(URL_getbooks))
					.header("Content-Type", "application/json").setHeader("Authorization", " Bearer " + token).GET()
					.build();
			HttpResponse<String> response = HttpClient.newBuilder().build().send(request,
					HttpResponse.BodyHandlers.ofString());

			System.out.println(response.statusCode());

			switch (response.statusCode()) {
			case (200):
				Gson g = new Gson();
				BooksList[] p = g.fromJson(response.body(), BooksList[].class);
				return Arrays.asList(p);
			default:
				return null;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
   
    /**
     *
     * @param token
     * @param addprstec
     * 
     * This method create a new prestec
     * 
     * @return message with successful confirmation or otherwise a null
     * 
     */
    public static Missatge addPrestec(String token, addprestec addprstec) {
        
		try {
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(URL_addprestec))
					.header("Content-Type", "application/json").setHeader("Authorization", "Bearer " + token)
					.POST(HttpRequest.BodyPublishers.ofString(new Gson().toJson(addprstec))).build();
			HttpResponse<String> response = HttpClient.newBuilder().build().send(request,
					HttpResponse.BodyHandlers.ofString());

			System.out.println(response.statusCode());
			System.out.println(response.body());
			switch (response.statusCode()) {
			case (200):
				Gson g = new Gson();
				return g.fromJson(response.body(), Missatge.class);
			default:
				return null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
   
    /**
     *
     * @param token
     * @param _id
     * @param prestecupdate
     * 
     * This method updates a prestec from an id passed through the url
     * 
     * @return message with successful confirmation or otherwise a null
     * 
     */
    public static Missatge updatePrestec(String token, String _id, PrestecUpdate prestecupdate) {
        
		try {
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(URL_updatePrestec+ _id))
					.header("Content-Type", "application/json").setHeader("Authorization", "Bearer " + token)
					.PUT(HttpRequest.BodyPublishers.ofString(new Gson().toJson( prestecupdate))).build();
			HttpResponse<String> response = HttpClient.newBuilder().build().send(request,
					HttpResponse.BodyHandlers.ofString());

			System.out.println(response.statusCode());
			System.out.println(response.body());
			switch (response.statusCode()) {
			case (200):
				Gson g = new Gson();
				return g.fromJson(response.body(), Missatge.class);
			default:
				return null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
    
    /**
     *
     * @param token
     * @param prestecId
     * 
     * This method removes an existing prestec
     * 
     * @return message with successful confirmation or otherwise a null
     * 
     */
    public static Missatge deletePrestec(String token, String prestecId) {
       
		try {
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(URL_deletePrestec + prestecId))
					.header("Content-Type", "application/json").setHeader("Authorization", "Bearer " + token).DELETE()
					.build();
			HttpResponse<String> response = HttpClient.newBuilder().build().send(request,
					HttpResponse.BodyHandlers.ofString());

			System.out.println(response.statusCode());
			System.out.println(response.body());
			switch (response.statusCode()) {
			case (200):
				Gson g = new Gson();
				return g.fromJson(response.body(), Missatge.class); 
			default:
				return null;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
   
   
    /**
     * @param token
     * 
     * @return List with prestecs
     */
    public static List<Prestecs> getPrestecs(String token) {
        
		try {
			System.out.println(URL_getprestecs);
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(URL_getprestecs))
					.header("Content-Type", "application/json").setHeader("Authorization", " Bearer " + token).GET()
					.build();
			HttpResponse<String> response = HttpClient.newBuilder().build().send(request,
					HttpResponse.BodyHandlers.ofString());

			System.out.println(response.statusCode());

			switch (response.statusCode()) {
			case (200):
				Gson g = new Gson();
				Prestecs[] p = g.fromJson(response.body(), Prestecs[].class);
				return Arrays.asList(p);
			default:
				return null;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
   
    /**
     *
     * @param token
     * @param addadutor
     * 
     * This method create a new book
     * 
     * @return message with successful confirmation or otherwise a null
     * 
     */
   public static Missatge addAutor(String token, Autor addautor) {
        
		try {
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(URL_addAutor))
					.header("Content-Type", "application/json").setHeader("Authorization", "Bearer " + token)
					.POST(HttpRequest.BodyPublishers.ofString(new Gson().toJson(addautor))).build();
			HttpResponse<String> response = HttpClient.newBuilder().build().send(request,
					HttpResponse.BodyHandlers.ofString());

			System.out.println(response.statusCode());
			System.out.println(response.body());
			switch (response.statusCode()) {
			case (200):
				Gson g = new Gson();
				return g.fromJson(response.body(), Missatge.class);
			default:
				return null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
   
    /**
     *
     * @param token
     * @param _id
     * @param updateautor
     * 
     * This method updates a autor from an id passed through the url
     * 
     * @return message with successful confirmation or otherwise a null
     * 
     */
    public static Missatge updateAutor(String token, String _id, Autor updateautor) {
        
		try {
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(URL_updateAutor+ _id))
					.header("Content-Type", "application/json").setHeader("Authorization", "Bearer " + token)
					.PUT(HttpRequest.BodyPublishers.ofString(new Gson().toJson(updateautor))).build();
			HttpResponse<String> response = HttpClient.newBuilder().build().send(request,
					HttpResponse.BodyHandlers.ofString());

			System.out.println(response.statusCode());
			System.out.println(response.body());
			switch (response.statusCode()) {
			case (200):
				Gson g = new Gson();
				return g.fromJson(response.body(), Missatge.class);
			default:
				return null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
   
    /**
     *
     * @param token
     * @param autorId
     * 
     * This method removes an existing autor
     * 
     * @return message with successful confirmation or otherwise a null
     * 
     */
    public static Missatge deleteAutor(String token, String autorId) {
       
		try {
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(URL_deleteAutor + autorId))
					.header("Content-Type", "application/json").setHeader("Authorization", "Bearer " + token).DELETE()
					.build();
			HttpResponse<String> response = HttpClient.newBuilder().build().send(request,
					HttpResponse.BodyHandlers.ofString());

			System.out.println(response.statusCode());
			System.out.println(response.body());
			switch (response.statusCode()) {
			case (200):
				Gson g = new Gson();
				return g.fromJson(response.body(), Missatge.class); 
			default:
				return null;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
    
    /**
     * @param token
     * 
     * @return List with autors
     */
    public static List<AutorList> getAutors(String token) {
        
		try {
			System.out.println(URL_getAutors);
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(URL_getAutors))
					.header("Content-Type", "application/json").setHeader("Authorization", " Bearer " + token).GET()
					.build();
			HttpResponse<String> response = HttpClient.newBuilder().build().send(request,
					HttpResponse.BodyHandlers.ofString());

			System.out.println(response.statusCode());

			switch (response.statusCode()) {
			case (200):
				Gson g = new Gson();
				AutorList[] p = g.fromJson(response.body(), AutorList[].class);
				return Arrays.asList(p);
			default:
				return null;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
    
    
    /**
     *
     * @param token
     * @param addcategoria
     * 
     * This method create a new category
     * 
     * @return message with successful confirmation or otherwise a null
     * 
     */
   public static Missatge addCategoria(String token, Category addcategoria) {
        
		try {
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(URL_addCategoria))
					.header("Content-Type", "application/json").setHeader("Authorization", "Bearer " + token)
					.POST(HttpRequest.BodyPublishers.ofString(new Gson().toJson(addcategoria))).build();
			HttpResponse<String> response = HttpClient.newBuilder().build().send(request,
					HttpResponse.BodyHandlers.ofString());

			System.out.println(response.statusCode());
			System.out.println(response.body());
			switch (response.statusCode()) {
			case (200):
				Gson g = new Gson();
				return g.fromJson(response.body(), Missatge.class);
			default:
				return null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
   
    /**
     *
     * @param token
     * @param _id
     * @param updatecategoria
     * 
     * This method updates a category from an id passed through the url
     * 
     * @return message with successful confirmation or otherwise a null
     * 
     */
    public static Missatge updateCategoria(String token, String _id, Category updatecategoria) {
        
		try {
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(URL_updateCategoria+ _id))
					.header("Content-Type", "application/json").setHeader("Authorization", "Bearer " + token)
					.PUT(HttpRequest.BodyPublishers.ofString(new Gson().toJson(updatecategoria))).build();
			HttpResponse<String> response = HttpClient.newBuilder().build().send(request,
					HttpResponse.BodyHandlers.ofString());

			System.out.println(response.statusCode());
			System.out.println(response.body());
			switch (response.statusCode()) {
			case (200):
				Gson g = new Gson();
				return g.fromJson(response.body(), Missatge.class);
			default:
				return null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
    
    /**
     *
     * @param token
     * @param categoriaId
     * 
     * This method removes an existing category
     * 
     * @return message with successful confirmation or otherwise a null
     * 
     */
    public static Missatge deleteCategory(String token, String categoriaId) {
       
		try {
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(URL_deleteCategoria + categoriaId))
					.header("Content-Type", "application/json").setHeader("Authorization", "Bearer " + token).DELETE()
					.build();
			HttpResponse<String> response = HttpClient.newBuilder().build().send(request,
					HttpResponse.BodyHandlers.ofString());

			System.out.println(response.statusCode());
			System.out.println(response.body());
			switch (response.statusCode()) {
			case (200):
				Gson g = new Gson();
				return g.fromJson(response.body(), Missatge.class); 
			default:
				return null;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
    
    /**
     * @param token
     * 
     * @return List with category
     */
    public static List<CategoryList> getCategories(String token) {
        
		try {
			System.out.println(URL_getCategories);
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(URL_getCategories))
					.header("Content-Type", "application/json").setHeader("Authorization", " Bearer " + token).GET()
					.build();
			HttpResponse<String> response = HttpClient.newBuilder().build().send(request,
					HttpResponse.BodyHandlers.ofString());

			System.out.println(response.statusCode());

			switch (response.statusCode()) {
			case (200):
				Gson g = new Gson();
				CategoryList[] p = g.fromJson(response.body(), CategoryList[].class);
				return Arrays.asList(p);
			default:
				return null;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
   
   
}
