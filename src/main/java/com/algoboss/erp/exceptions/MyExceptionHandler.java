/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algoboss.erp.exceptions;

import java.util.Iterator;
import javax.faces.FacesException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;


/**
 *
 * @author Agnaldo
 */
public class MyExceptionHandler extends ExceptionHandlerWrapper {

  //private static Log log = LoggerFactory.getLog(MyExceptionHandler.class);
  private ExceptionHandler wrapped;

  public MyExceptionHandler(ExceptionHandler wrapped) {
    this.wrapped = wrapped;
  }

  @Override
  public ExceptionHandler getWrapped() {
    return wrapped;
  }

  @Override
  public void handle() throws FacesException {
    //Iterate over all unhandeled exceptions
    Iterator i = getUnhandledExceptionQueuedEvents().iterator();
    while (i.hasNext()) {
      ExceptionQueuedEvent event = (ExceptionQueuedEvent)i.next();
      ExceptionQueuedEventContext context =
        (ExceptionQueuedEventContext)event.getSource();

      //obtain throwable object
      Throwable t = context.getException();

      //here you do what ever you want with exception
      try{
      //log error
        //log.error("Serious error happened!", t);
        //redirect to error view etc....  
      }finally{
        //after exception is handeled, remove it from queue
        i.remove();
      }
    }
    //let the parent handle the rest
    getWrapped().handle();
  }
}
