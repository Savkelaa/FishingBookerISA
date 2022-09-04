import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import "../App.css";

import boatServices from "../Services/BoatServices/BoatServices";
import cottageServices from "../Services/CottageServices/CottageServices";
import userServices from "../Services/UserServices/UserServices";
import { Link } from "react-router-dom";
import {
    Card,
    ListGroup,
    ListGroupItem,
    CardGroup,
    Button,
  } from "react-bootstrap";

function AllBoatsContainer() {
  const [boats, setBoats] = useState(JSON.parse(localStorage.getItem("BoatsFollow")));
  const [avgRate, setavgRate]= useState();
  const [cottages, setCottages] = useState(JSON.parse(localStorage.getItem("CottagesFollow")));


  const [instructors, setInstructors] = useState(JSON.parse(localStorage.getItem("InstructorsFollow")));


  function unfollowCottage(cottage){
    cottages.pop(cottage)
    localStorage.setItem("CottagesFollow", JSON.stringify(cottages));
  }
  function unfollowBoat(boat){
    boats.pop(boat)
    localStorage.setItem("BoatsFollow", JSON.stringify(boats));
}
function unfollowInstructor(instructor){
    cottages.pop(instructor)
    localStorage.setItem("InstructorsFollow", JSON.stringify(instructors));
}
  
  return (
    <div>
      {" "}
      <Navbarr></Navbarr>
      <div>
      <div className="header">
        <h1 style={{ textAlign: "center" }}> Boats </h1>
      </div>
      {boats?.map((boat) => (
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
                      <ListGroupItem>Rate: {avgRate} </ListGroupItem>
                    </ListGroup>
                    <Card.Body>
                   
                        <Button
                          style={{ width: "8rem" }}
                          variant="outline-success"
                          onClick={()=>{
                            unfollowBoat(boat)
                          }}
                        >
                          Unfollow
                        </Button>
                   
                    </Card.Body>
                  </Card>
                </div>
              </div>
            </div>
          </div>
        </div>
      ))}
    </div>
    <div>
    <div className="header">
        <h1 style={{ textAlign: "center" }}> Cottages </h1>
      </div>
      {cottages?.map((cottage) => (
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
                      <ListGroupItem>Rate: {cottage.averageRate} </ListGroupItem>
                    </ListGroup>
                    <Card.Body>
                    
                        <Button
                          style={{ width: "8rem" }}
                          variant="outline-success"
                          onClick={()=>{
                            unfollowCottage(cottage)
                          }}
                        >
                          Unfollow
                        </Button>
                    
                    </Card.Body>
                  </Card>
                </div>
              </div>
            </div>
          </div>
        </div>
      ))}
    </div>
    <div>
      <div className="header">
        <h1 style={{ textAlign: "center" }}> All Instructors </h1>
      </div>
      {instructors?.map((instructor) => (
        <div className="container">
          <div className="row gutters">
            <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
              <div className="card h-100">
                <div className="card-body">
                  <Card className="cardContainer" style={{ width: "30rem" }}>
                    <Card.Img variant="top" />
                    <Card.Body>
                      <Card.Title className="cardTitle">
                        {instructor.name} {instructor.surname}
                      </Card.Title>
                      <Card.Text>{instructor.email}</Card.Text>
                      <Card.Text>Biography: {instructor.biography}</Card.Text>
                    </Card.Body>
                    <ListGroup className="list-group-flush">
                      <ListGroupItem>
                        Address: {instructor.address}, {instructor.city},{" "}
                        {instructor.country}
                      </ListGroupItem>
                      <ListGroupItem>
                        Phone number: {instructor.number}
                      </ListGroupItem>
                      <ListGroupItem>
                        Rate: {instructor.averageRate}
                      </ListGroupItem>
                      <ListGroupItem>
                        Explanation of registration: {instructor.explanation}
                      </ListGroupItem>
                    </ListGroup>
                    <Card.Body>
                   
                        <Button
                          style={{ width: "8rem" }}
                          variant="outline-success"
                          onClick={()=>{
                            unfollowInstructor(instructor)
                          }}
                        >
                          Unfollow
                        </Button>
           
                    </Card.Body>
                  </Card>
                </div>
              </div>
            </div>
          </div>
        </div>
      ))}
    </div>
      <Footerr></Footerr>
    </div>
  );
}

export default AllBoatsContainer;
