import { Form } from "react-router-dom";
import Card from "../ui/Card";
import classes from "./Search.module.css";
const Search = (props) => {
  const searchHandler = (e) => {
    const query = e.target.value;
    fetch("http://localhost:4444/contact/?lastName=" + query)
      .then((response) => response.json())
      .then((responseData) => {
        const contacts = [];

        for (const key in responseData) {
          contacts.push({
            id: responseData[key].id,
            firstName: responseData[key].firstName,
            lastName: responseData[key].lastName,
            phone: responseData[key].phone,
          });
        }
        props.setContacts(contacts);
      });
  };
  return (
    <Card>
      <Form className={classes.form}>
        <input
          name="search"
          placeholder="search for contact by last name ..."
          type="text"
          onChange={searchHandler}
        />
      </Form>
    </Card>
  );
};

export default Search;
