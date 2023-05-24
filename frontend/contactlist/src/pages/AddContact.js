import ContactForm from "../components/ContactForm";
import classes from "./AddContact.module.css";
import Card from "../ui/Card";
const AddContact = () => {
  return (
    <Card>
      <div className={classes.main}>
        <h1>Contact Form</h1>
        <ContactForm />
      </div>
    </Card>
  );
};

export default AddContact;
