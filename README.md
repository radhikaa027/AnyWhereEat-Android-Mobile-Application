# AnyWhereEat - Food Ordering Mobile Application

## Table of Contents
1. [Project Overview](#project-overview)
2. [Features](#features)
3. [Technology Stack](#technology-stack)
4. [Installation and Setup](#installation-and-setup)
5. [Application Structure](#application-structure)
6. [Screenshots](#screenshots)
7. [Future Enhancements](#future-enhancements)
9. [License](#license)

---

## Project Overview

AnyWhereEat is an Android-based mobile application designed to provide a seamless experience for both customers and restaurant administrators. The application allows users to browse, select, and order food from various restaurants while enabling restaurant owners to manage orders and menus efficiently. The app ensures a user-friendly interface for customers and an effective order management system for businesses.

The application is divided into two primary interfaces:
- **User App**: Customers can browse food categories, add items to the cart, and place orders.
- **Admin App**: Restaurant owners can manage menus, track pending/completed orders, and oversee delivery status.

## Features
### User App
- User authentication (Sign up/Login)
- Browse different food categories
- View detailed descriptions, ratings, and pricing
- Add items to cart and place orders
- Apply coupon codes
- Set preferred delivery location and time
- Track order status in real-time

### Admin App
- Admin authentication (Sign up/Login)
- Manage food menu (Add/Edit/Delete items)
- View pending and completed orders
- Order dispatch management
- Earnings overview dashboard

## Technology Stack
- **Programming Language**: Java
- **User Interface**: XML
- **Backend**: Firebase Authentication & Firebase Realtime Database
- **Libraries Used**:
  - Glide (Image Loading)
  - RecyclerView (Efficient list rendering)
  - FirebaseAuth (User authentication)
  - FirebaseDatabase (Real-time data storage)

## Installation and Setup
### Prerequisites
- Android Studio installed
- Firebase Project setup with authentication and database
- Emulator or Android device for testing

### Steps to Setup
1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/AnyWhereEat.git
   cd AnyWhereEat
   ```
2. Open the project in Android Studio.
3. Connect Firebase by adding the **google-services.json** file.
4. Sync Gradle files and build the project.
5. Run the application on an emulator or an Android device.


## Working Flowchart
- **User**
  ![image](https://github.com/user-attachments/assets/fb4bdf3e-99e5-4c51-99fb-435676c41bbe)

- **Admin**
  ![image](https://github.com/user-attachments/assets/da8f66e0-6b03-438a-9aa5-a08ef5954548)



## Future Enhancements
- Implement payment gateway integration
- Enable order tracking with GPS
- Develop iOS version of the app
- Implement AI-based food recommendations
- Multi-language support

## License
This project is licensed under the MIT License - see the LICENSE file for details.

