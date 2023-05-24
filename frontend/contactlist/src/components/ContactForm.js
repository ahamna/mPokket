import { useNavigate, Form } from "react-router-dom";
import { useState } from "react";
import classes from "./Contactform.module.css";

function ContactForm(props) {
  const navigate = useNavigate();
  function cancelHandler() {
    navigate("..");
  }

  const [firstName, setFirstName] = useState();
  const [lastName, setLastName] = useState();
  const [phone, setPhone] = useState();

  const handleFirstNameChange = (e) => {
    setFirstName(e.target.value);
  };

  const handleLastNameChange = (e) => {
    setLastName(e.target.value);
  };

  const handlePhoneChange = (e) => {
    setPhone(e.target.value);
  };

  const handleForm = (e) => {
    e.preventDefault();
    const data = {
      firstName,
      lastName,
      phone,
    };
    fetch("http://localhost:4444/contact/", {
      method: "POST",
      headers: {
        "content-type": "application/json",
      },
      body: JSON.stringify(data),
    })
      .then((res) => res.json())
      .then((data) => {
        console.log(data);
        setFirstName("");
        setLastName("");
        setPhone("");
        navigate("/");
      })
      .catch((err) => console.error(err));
  };

  return (
    <Form method="post" onSubmit={handleForm} className={classes.form}>
      <p>
        <label htmlFor="firstName">First Name:</label>
        <input
          id="firstName"
          type="text"
          name="firstName"
          onChange={handleFirstNameChange}
        />
      </p>

      <p>
        <label htmlFor="lastname">Last Name: </label>
        <input
          id="lastName"
          type="text"
          name="lastName"
          onChange={handleLastNameChange}
        />
      </p>
      <p>
        <label htmlFor="phone">Phone:</label>
        <input
          id="phone"
          type="text"
          name="phone"
          onChange={handlePhoneChange}
        />
      </p>

      <div className={classes.actions}>
        <button type="button" onClick={cancelHandler}>
          Cancel
        </button>
        <button>Save</button>
      </div>
    </Form>
  );
}

export default ContactForm;
