package controller;

interface Auht {
    boolean auth(String user, String password);

    boolean insertDB(String Nome, String Senha, String adm);

    boolean deleteElement(String Nome);

    boolean isAdm(String Nome);

    boolean UpdateUser(String user, String Nome, String senha, String adm);

    boolean AddEvent(String evento, String tell, String local, String bairro, int[] data);

}
