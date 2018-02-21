

/**
 * UserService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.4  Built on : Oct 21, 2016 (10:47:34 BST)
 */

    package com.bruce.service;

    /*
     *  UserService java interface
     */

    public interface UserService {
          

        /**
          * Auto generated method signature
          * 
                    * @param getUsers0
                
         */

         
                     public com.bruce.service.GetUsersResponse getUsers(

                        com.bruce.service.GetUsers getUsers0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getUsers0
            
          */
        public void startgetUsers(

            com.bruce.service.GetUsers getUsers0,

            final com.bruce.service.UserServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    