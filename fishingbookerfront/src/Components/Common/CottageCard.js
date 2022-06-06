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

export default function CottageCard({ cottages }) {
  console.log("cottages", cottages);
  return (
    <div>
      {cottages.map((cottage) => (
        <div className="container">
          <div className="row gutters">
            <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
              <div className="card h-100">
                <div className="card-body">
                  <Card className="cardContainer" style={{ width: "30rem" }}>
                    <Card.Body>
                      <Card.Title className="cardTitle">
                        {cottage.name}
                      </Card.Title>
                      <Card.Text>{cottage.promoDescription}</Card.Text>
                    </Card.Body>
                    <ListGroup className="list-group-flush">
                      <ListGroupItem>Address: {cottage.address}</ListGroupItem>
                      <ListGroupItem>
                        Number of rooms : {cottage.numRooms}
                      </ListGroupItem>
                      <ListGroupItem>
                        Number of beds : {cottage.numBeds}
                      </ListGroupItem>
                      <ListGroupItem>Price: {cottage.price} euro</ListGroupItem>
                    </ListGroup>
                    <Card.Body>
                      <Link to={`/cottage/${cottage.id}`}>
                        <Button
                          style={{ width: "8rem" }}
                          variant="outline-success"
                        >
                          More info
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
