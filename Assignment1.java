package assignment1;

import java.util.Scanner;

import javax.xml.crypto.Data;

import java.util.ArrayList;

public class Assignment1 {

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    AdminUser Admin = new AdminUser();
    Admin.setAdminUser();
    int choice;
    do {
      System.out.println("1-Login");
      System.out.println("2-Register");
      System.out.println("3-EXIT");
      System.out.print("Your choice is: ");
      choice = input.nextInt();
      switch (choice) {
        case 1: {
          Login login = new Login();
          System.out.println("1-Login as driver");
          System.out.println("2-Login as user");
          System.out.println("3-Login as Admin");
          System.out.print("Your choice is: ");
          int ch1 = input.nextInt();
          if (ch1 > 3) {
            System.out.println("Failed choice");
            break;
          }
          System.out.print("User name:");
          String name = input.next();
          System.out.print("Password:");
          String pass = input.next();
          switch (ch1) {
            case 1: {
              Driver driver = new Driver();
              driver = login.logInAsDriver(name, pass);
              if (driver != null) {
                int ch2;
                System.out.println("====================Welcome " +
                    driver.driverInfo.getUserName()
                    + "====================");
                do {
                  System.out.println("======================Driver" + (login.getDriverIndex())
                      + "======================");
                  System.out.println("1-Add a new favourite area.");
                  System.out.println("2-See all requests trip and add offer.");
                  System.out.println("3-See all favourite areas.");
                  System.out.println("4-End Ride.");
                  System.out.println("5-See all rides history.");
                  System.out.println("6-See all balances.");
                  System.out.println("7-Logout.");
                  System.out.print("Your choice is: ");
                  ch2 = input.nextInt();

                  int price;
                  switch (ch2) {
                    case 1: {
                      System.out.print("Enter the number of favourite area you have: ");
                      int favAreaNumbers = input.nextInt();
                      for (int x = 0; x < favAreaNumbers; x++) {
                        System.out.print("Enter new Favourite area: ");
                        String favarea = input.next();
                        FavArea favArea = new FavArea();
                        favArea.addFavArea(driver, favarea);
                      }
                      break;
                    }
                    case 2: {
                      driver.printRequestTrip();
                      for (int x = 0; x < driver.getRequestTrip().size(); x++) {
                        System.out
                            .println(
                                "===============The Driver(" + login.getDriverIndex()
                                    + ") Suggested The Price Of The Trip(" + (x + 1)
                                    + ")===============");
                        System.out
                            .print("Enter the suggestion price to trip(" + (x + 1) + "): ");
                        price = input.nextInt();
                        Offer offer = new Offer(driver, driver.getRequestTrip().get(x), price);
                        driver.setOffer(offer);
                      }
                      break;
                    }
                    case 3: {
                      for (int x = 0; x < driver.getFavArea().size(); x++) {
                        System.out.println(
                            "Favourite area(" + (x + 1) + "): "
                                + driver.getFavArea().get(x).favArea);
                      }
                      break;
                    }
                    case 4: {
                      if (driver.selectedOfferList.size() != 0)
                        driver.EndRide();
                      else
                        System.out.println("There is no ride to end it.");
                      break;
                    }
                    case 5: {
                      driver.printRideHistory();
                      break;
                    }

                    case 6: {
                      driver.printDriverBalance();
                      break;
                    }

                    case 7: {
                      System.out.println("===================Driver" + (login.getDriverIndex())
                          + " has logged out===================");
                      break;
                    }
                    default: {
                      System.out.println("Failed choice");
                      break;
                    }
                  }

                } while (ch2 != 7);

              }
              break;
            }
            case 2: {
              User user = new User();
              user = login.logInAsUser(name, pass);
              if (user != null) {
                int ch3;
                System.out.println("======================Welcome " +
                    user.getUserInfo().getUserName()
                    + "======================");
                do {
                  System.out.println("======================User" + (login.getUserIndex())
                      + "======================");
                  System.out.println("1-Request new ride.");
                  System.out.println("2-See all Offers.");
                  System.out.println("3-Check the driver details for each offer.");
                  System.out.println("4-Select Offer.");
                  System.out.println("5-See all rides history.");
                  System.out.println("6-Rate any ride histoy.");
                  System.out.println("7-Logout.");
                  System.out.print("Your choice is: ");
                  ch3 = input.nextInt();
                  switch (ch3) {
                    case 1: {
                      System.out.print("Enter the source Area: ");
                      String sourceArea = input.next();
                      System.out.print("Enter the destination Area: ");
                      String destinationArea = input.next();
                      RequestTrip requesttrip = new RequestTrip(user, sourceArea,
                          destinationArea);
                      user.requestTrip(requesttrip);
                      AreaLocation area = new AreaLocation();
                      double x = area.latsearch(sourceArea);
                      double y = area.lonsearch(sourceArea);
                      double z = area.latsearch(destinationArea);
                      double q = area.lonsearch(destinationArea);
                      Haversine h = new Haversine();
                      System.out.println("The distance between two area is:" + h.haversine(x, y, z, q));
                      double time = h.haversine(x, y, z, q) / 60;
                      System.out.println("The time between two area is:" + time);
                      break;
                    }
                    case 2: {
                      user.printOffers();
                      break;
                    }
                    case 3: {
                      user.printDriverDeyailsToEachOffer();
                      break;
                    }
                    case 4: {
                      System.out.print("Enter the price that you are selected: ");
                      double p = input.nextDouble();
                      user.setOffer(p);
                      break;
                    }
                    case 5: {
                      if (user.rideHistory.size() != 0) {
                        user.printRideHistory();
                      } else
                        System.out.println("The ride history of user is empty");
                      break;
                    }
                    case 6: {
                      System.out.print("Do you want to rate all drivers?(y/n)");
                      String ch = input.next();
                      user.rateRide(ch);
                      break;
                    }
                    case 7: {
                      System.out.println("===================User" +
                          (DataBase.UserList.indexOf(user) + 1)
                          + " has logged out===================");
                      break;
                    }

                    default: {
                      System.out.println("Failed choice");
                      break;
                    }
                  }
                } while (ch3 != 7);
              }
              break;
            }
            case 3: {
              AdminUser admin = new AdminUser();
              admin = login.logInAsAdmin(name, pass);
              if (admin != null) {
                System.out.print("Do you want to see pending driver list?(y/n)");
                String bool = input.next();
                if (bool.equals("y")) {
                  for (int i = 0; i < admin.getPendingDriverList().size(); i++) {
                    System.out.println("====================Pending Driver" + (i + 1)
                        + "====================");
                    admin.getPendingDriverList().get(i).printDriver();
                  }
                  System.out.println(
                      "===========================================================");
                  System.out.print("Do you want to verify pending driver list?(y/n)");
                  String bool1 = input.next();
                  if (bool1.equals("y")) {
                    admin.verifyPendingDriverList();
                    System.out.println("The pending driver list verify has been completed.");
                  }
                }
              }
              break;
            }
            default: {
              System.out.println("Failed choice");
              break;
            }
          }
          break;
        }
        case 2: {
          System.out.println("1-Register as driver");
          System.out.println("2-Register as user");
          System.out.println("3-Return");
          System.out.print("Your choice is: ");
          int ch1 = input.nextInt();
          if (ch1 > 2) {
            System.out.println("Failed choice");
            break;
          }
          System.out.print("User name: ");
          String userName = input.next();
          System.out.print("Email: ");
          String Email = input.next();
          System.out.print("Password: ");
          String Password = input.next();
          System.out.print("PhoneNumber: ");
          int phoneNumber = input.nextInt();
          Info driverInfo = new Info(userName, phoneNumber, Email, Password);
          switch (ch1) {
            case 1: {
              System.out.print("National ID: ");
              int nationalID = input.nextInt();
              System.out.print("Driving license: ");
              String drivingLicense = input.next();
              Driver driver = new Driver(driverInfo, nationalID, drivingLicense);
              DriverRegister driverRegister = new DriverRegister();
              driverRegister.register(driver);
              System.out.println("Your Registration has been pending.");
              break;
            }
            case 2: {
              User user = new User(driverInfo);
              UserRegister userRegister = new UserRegister();
              userRegister.register(user);
              System.out.println("Your registration has been succeeded.");
              break;
            }
            default: {
              System.out.println("Failed choice");
              break;
            }
          }
          break;
        }
        case 3: {
          break;
        }
        default: {
          System.out.println("Failed choice");
          break;
        }
      }
      System.out.println(
          "===========================================================");

    } while (choice != 3);
  }

}
