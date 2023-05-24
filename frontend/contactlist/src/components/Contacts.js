import { useState, useEffect } from "react";
import Card from "../ui/Card";
import Contact from "./Contact";
const Contacts = (props) => {
  const [contacts, setContacts] = useState(props.contacts);

  useEffect(() => {
    setContacts(props.contacts);
  }, [props.contacts]);

  const deleteHandler = (contactId) => {
    fetch(`http://localhost:4444/contact/${contactId}`, {
      method: "DELETE",
    })
      .then((response) => {
        setContacts((contacts) =>
          contacts.filter((contact) => contact.id !== contactId)
        );
      })
      .catch((error) => {
        console.log(error);
      });
  };
  return (
    <Card>
      <ul>
        {contacts.map((contact) => (
          <li key={contact.id}>
            <Contact contact={contact} deleteHandler={deleteHandler} />
          </li>
        ))}
      </ul>
    </Card>
  );
};

export default Contacts;
