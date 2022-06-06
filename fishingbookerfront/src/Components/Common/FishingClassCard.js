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

export default function FishingClassCard({ fishingClasses }) {
  console.log(`fishingClasses`, fishingClasses);

  return (
    <div>
      {fishingClasses.map((fishingClass) => (
        <div className="container">
          <div className="row gutters">
            <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
              <div className="card h-100">
                <div className="card-body">
                  <Card className="cardContainer" style={{ width: "30rem" }}>
                    <Card.Img
                      variant="top"
                      src="https://assets.orvis.com/is/image/orvisprd/FF101_2018_PondCasting_0149_1?wid=1980&src=is($object$:7-3)"
                    />
                    <Card.Body>
                      <Card.Title className="cardTitle">
                        {fishingClass.name}
                      </Card.Title>
                      <Card.Text>{fishingClass.promoDescription}</Card.Text>
                    </Card.Body>
                    <ListGroup className="list-group-flush">
                      <ListGroupItem>
                        Address: {fishingClass.address}
                      </ListGroupItem>
                      <ListGroupItem>
                        Max number of people : {fishingClass.maxPeople}
                      </ListGroupItem>
                      <ListGroupItem>
                        Price: {fishingClass.price} euro
                      </ListGroupItem>
                    </ListGroup>
                    <Card.Body>
                      <Button
                        style={{ width: "8rem" }}
                        variant="outline-success"
                      >
                        Book
                      </Button>
                      <Link to={`/fishing/${fishingClass.id}`}>
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
