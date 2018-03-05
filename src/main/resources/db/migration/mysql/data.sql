use bugs;

INSERT INTO bugged_test (scenario_tag, bug_id) VALUES ("584-3", 1);
INSERT INTO bugged_test (scenario_tag, bug_id) VALUES ("584-4", 1);

# bugs
INSERT INTO bug (description, is_active_int, is_active_sys, issue) VALUES ("test", 1, 1, "test-33");
INSERT INTO bug (description, is_active_int, is_active_sys, issue) VALUES ("test1", 1, 0, "test-34");