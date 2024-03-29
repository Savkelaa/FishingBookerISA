import React, { useRef, useState } from "react";
import {
  Card,
  ListGroup,
  ListGroupItem,
  CardGroup,
  Button,
} from "react-bootstrap";
import "../../App.css";
import { Link } from "react-router-dom";

export default function FishingClassCardByInstructor({
  fishingClassesByInstructor,
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
        name="search-fishingClass"
        placeholder="Search fishing classes by name.."
        onKeyUp={(e) => changeFilterClientsText(search.current.value)}
      ></input>
      {fishingClassesByInstructor.map((fishingClass) => (
        <div className="container">
          <div className="row gutters">
            <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
              <div className="card h-100">
                <div className="card-body">
                  <Card className="cardContainer" style={{ width: "30rem" }}>
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
                      <ListGroupItem>
                        Cancellation Condition:{" "}
                        {fishingClass.cancellationCondition} %
                      </ListGroupItem>
                     
                    </ListGroup>
                    <Card.Body>
                      <Link to={`/createQuickReservation/${fishingClass.id}`}>
                        <Button
                          style={{ width: "8rem" }}
                          variant="outline-success"
                        >
                          Create quick reservation
                        </Button>
                      </Link>
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
