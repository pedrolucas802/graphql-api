package br.com.unifor.resource;

import br.com.unifor.domain.UserEntity;
import br.com.unifor.service.UserService;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Mutation;

import jakarta.inject.Inject;
import java.util.List;

@GraphQLApi
public class UserGraphQLResource {

    @Inject
    UserService userService;

    @Query
    @Description("Get a list of all user entries")
    public List<UserEntity> allUsers() {
        return userService.list();
    }

    @Mutation
    @Description("Create a new user entry")
    public UserEntity createUser(UserEntity user) {
        return userService.create(user);
    }

    @Mutation
    @Description("Update an existing user entry")
    public UserEntity updateUser(UserEntity user) {
        return userService.update(user);
    }

    @Query
    @Description("Find a user entry by ID")
    public UserEntity findUserById(Long id) {
        return userService.findById(id);
    }

    @Mutation
    @Description("Delete a user entry by ID")
    public boolean deleteUser(Long id) {
        return userService.delete(id);
    }
}
