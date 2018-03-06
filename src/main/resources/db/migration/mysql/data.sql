use bugs_dev;

INSERT INTO bugged_test (scenario_tag, bug_id) VALUES ("584-3", 1);
INSERT INTO bugged_test (scenario_tag, bug_id) VALUES ("584-4", 1);
INSERT INTO bugged_test (scenario_tag, bug_id) VALUES ("33-4", 3);

# bugs
INSERT INTO bug (description, is_active_int, is_active_sys, issue) VALUES ("test", 1, 1, "test-33");
INSERT INTO bug (description, is_active_int, is_active_sys, issue) VALUES ("test1", 1, 0, "test-34");
INSERT INTO bug (description, is_active_int, is_active_sys, issue) VALUES ("Big bug", 1, 0, "test-323");
INSERT INTO bug (description, is_active_int, is_active_sys, issue) VALUES ("Big bug 2", 1, 1, "test-113");


# users
INSERT INTO users (username, email, password, full_name) VALUES ("shane", "shane@suirtech.com", "password", "shane c");
INSERT INTO users (username, email, password, full_name) VALUES ("user", "user@suirtech.com", "password", "shane d");



# roles
INSERT INTO roles (role) VALUES ("ROLE_ADMIN");
INSERT INTO roles (role) VALUES ("ROLE_USER");


# user roles
INSERT INTO users_roles (user_id, role_id) VALUES (1,1);
INSERT INTO users_roles (user_id, role_id) VALUES (1,2);
INSERT INTO users_roles (user_id, role_id) VALUES (2,2);
