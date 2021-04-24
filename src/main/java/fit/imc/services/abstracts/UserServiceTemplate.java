package fit.imc.services.abstracts;

import java.util.List;

import fit.imc.models.mongo.User;

public interface UserServiceTemplate {
    public List<User> getAll();
    public void add(User user);
}
