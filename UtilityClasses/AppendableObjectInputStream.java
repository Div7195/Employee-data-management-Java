package UtilityClasses;

import java.io.*;
public class AppendableObjectInputStream extends ObjectInputStream {

    public AppendableObjectInputStream(InputStream in) throws IOException {
        super(in);
    }

    @Override
    protected void readStreamHeader() throws IOException {
        
    }
}