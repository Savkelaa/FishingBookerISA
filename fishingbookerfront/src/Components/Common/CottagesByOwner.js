import React, { useRef } from "react";
import {
  Card,
  ListGroup,
  ListGroupItem,
  CardGroup,
  Button,
} from "react-bootstrap";
import "../../App.css";
import { Link } from "react-router-dom";

export default function CottagesByOwner({
  cottagesByOwner,
  changeFilterClientsText,
  filterText,
}) {
  const search = useRef("");

  return (
    <div>
      <input
        ref={search}
        type="search"
        className="form-control"
        name="search-cottage"
        placeholder="Search fishing classes by name.."
        onKeyUp={(e) => changeFilterClientsText(search.current.value)}
      ></input>
      {cottagesByOwner.map((cottage) => (
        <div className="container">
          <div className="row gutters">
            <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
              <div className="card h-100">
                <div className="card-body">
                  <Card className="cardContainer" style={{ width: "30rem" }}>
                    <Card.Img
                      variant="top"
                      src="holder.js/100px180?text=Image cap"
                    />
                    <Card.Body>
                      <Card.Title className="cardTitle">
                        {cottage.name}
                      </Card.Title>
                      <Card.Text>{cottage.promoDescription}</Card.Text>
                    </Card.Body>
                    <ListGroup className="list-group-flush">
                      <ListGroupItem>
                        Address: {cottage.address}
                      </ListGroupItem>
                      
                      <ListGroupItem>
                        Price: {cottage.price} euro
                      </ListGroupItem>
                      
                    </ListGroup>
                    <Card.Body>
                      <Link to={`/createQuickReservation/${cottage.id}`}>
                        <Button
                          style={{ width: "8rem" }}
                          variant="outline-success"
                        >
                          Create quick reservation
                        </Button>
                      </Link>
                      <Link to={`/cottage/${cottage.id}`}>
                        <Button
                          style={{ width: "8rem" }}
                          variant="outline-info"
                        >
                          More details
                        </Button>
                      </Link>
                    </Card.Body>
                  </Card>
                </div>
              </div>
            </div>
          </div>
        </div>
      ))}
    </div>
  );
}
