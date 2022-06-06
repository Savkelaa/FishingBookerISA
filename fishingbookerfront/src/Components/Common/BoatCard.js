import React from "react";
import {
  Card,
  ListGroup,
  ListGroupItem,
  CardGroup,
  Button,
} from "react-bootstrap";
import "../../App.css";
import { Link } from "react-router-dom";

export default function BoatCard({ boats }) {
  console.log("boats", boats);
  return (
    <div>
      {boats.map((boat) => (
        <div className="container">
          <div className="row gutters">
            <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
              <div className="card h-100">
                <div className="card-body">
                  <Card className="cardContainer" style={{ width: "30rem" }}>
                    <Card.Body>
                      <Card.Title className="cardTitle">{boat.name}</Card.Title>
                      <Card.Text>{boat.promoDescription}</Card.Text>
                    </Card.Body>
                    <ListGroup className="list-group-flush">
                      <ListGroupItem>Type: {boat.type}</ListGroupItem>
                      <ListGroupItem>Length: {boat.length}</ListGroupItem>
                      <ListGroupItem>Address: {boat.address}</ListGroupItem>
                      <ListGroupItem>
                        Numer of motors: {boat.num_motors}
                      </ListGroupItem>
                      <ListGroupItem>
                        Motor power: {boat.motorPower}
                      </ListGroupItem>
                      <ListGroupItem>Max Speed: {boat.maxSpeed}</ListGroupItem>
                      <ListGroupItem>Status: {boat.status}</ListGroupItem>
                      <ListGroupItem>Price: {boat.price} euro</ListGroupItem>
                    </ListGroup>
                    <Card.Body>
                      <Link to={`/boat/${boat.id}`}>
                        <Button
                          style={{ width: "8rem" }}
                          variant="outline-success"
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
