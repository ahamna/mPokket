import Card from "../ui/Card";
import deleteBtm from "../icons8-delete.svg";
const Contact = (props) => {
  const contact = props.contact;
  return (
    <Card>
      <div>
        <p>{`${contact.firstName} ${contact.lastName}`}</p>
      </div>
      <div>{contact.phone}</div>
      <button onClick={props.deleteHandler.bind(this, contact.id)}>
        <img src={deleteBtm} alt="Delete" />
      </button>
    </Card>
  );
};

export default Contact;
