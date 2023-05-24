import { Link } from "react-router-dom";
import logo from "../phone-book-svgrepo-com.svg";
import classes from "./Root.module.css";
import Search from "../components/Search";
import { useState, useEffect } from "react";
import Contacts from "../components/Contacts";
const Root = () => {
  const [contacts, setContacts] = useState([]);

  useEffect(() => {
    fetch("http://localhost:4444/contact")
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
        setContacts(contacts);
      });
  }, []);
  return (
    <>
      <header>
        <div className={classes.logo}>
          <img src={logo} alt="Phone Book" />
        </div>
        <div className={classes["header-text"]}>
          <h1>Phone Book App</h1>
        </div>
      </header>
      <div className={classes.nav}>
        <ul>
          <li>
            <h3>Contacts</h3>
          </li>
          <li className={classes.button}>
            <Link to="add">+AddContact</Link>
          </li>
        </ul>
      </div>
      <Search setContacts={setContacts} />
      <Contacts contacts={contacts} />
    </>
  );
};

export default Root;
