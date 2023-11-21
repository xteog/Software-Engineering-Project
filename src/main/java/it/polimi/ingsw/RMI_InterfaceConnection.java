package it.polimi.ingsw;

import it.polimi.ingsw.messages.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;

public interface RMI_InterfaceConnection extends Remote {
    void selfSend(RMI_InterfaceConnection r) throws ServerNotActiveException, RemoteException, InterruptedException;

    void write(Message m) throws RemoteException;

    Message getMessage() throws RemoteException;

    void ping() throws RemoteException;

}


