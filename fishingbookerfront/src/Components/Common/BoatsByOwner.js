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

export default function BoatsByOwner({
  boatsByOwner,
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
        name="search-boat"
        placeholder="Search boats by name.."
        onKeyUp={(e) => changeFilterClientsText(search.current.value)}
      ></input>
      {boatsByOwner.map((boat) => (
        <div className="container">
          <div className="row gutters">
            <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
              <div className="card h-100">
                <div className="card-body">
                  <Card className="cardContainer" style={{ width: "30rem" }}>
                    
                    <Card.Body>
                      <Card.Title className="cardTitle">
                        {boat.name}
                      </Card.Title>
                      <Card.Text>{boat.promoDescription}</Card.Text>
                    </Card.Body>
                    <ListGroup className="list-group-flush">
                      <ListGroupItem>
                        Address: {boat.address}
                      </ListGroupItem>
                      
                      <ListGroupItem>
                        Price: {boat.price} euro
                      </ListGroupItem>
                      
                    </ListGroup>
                    <Card.Body>
                      <Link to={`/createBoatQuickReservationAction/${boat.id}`}>
                        <Button
                          style={{ width: "8rem" }}
                          variant="outline-success"
                        >
                          Create quick reservation
                        </Button>
                      </Link>
                      <Link to={`/boat/${boat.id}`}>
                        <Button
                          style={{ width: "8rem" }}
                          variant="outline-info"
                        >
                          More details
                        </Button>
                      </Link>

                      <Link to={`/boatAvailabilityPeriod/${boat.id}`}>
                        <Button
                          style={{ width: "8rem" }}
                          variant="outline-info"
                        >
                          Enter availability Period
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
