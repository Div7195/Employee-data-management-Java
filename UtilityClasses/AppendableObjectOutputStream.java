package UtilityClasses;
import java.util.*;
import java.io.*;
  public  class AppendableObjectOutputStream extends ObjectOutputStream {

        public AppendableObjectOutputStream(OutputStream out)
                throws IOException {
            super(out);
        }
    
        @Override
        protected void writeStreamHeader() throws IOException {
            
        }
    }

