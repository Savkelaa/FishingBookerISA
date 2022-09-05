import React, { useState, useEffect } from "react";
import userServices from "../../Services/UserServices/UserServices";
import {
  Card,
  ListGroup,
  ListGroupItem,
  CardGroup,
  Button,
} from "react-bootstrap";


export default function Instructors({ instructors, updateInstructorHandler }) {
  console.log("instructors", instructors);

  const [mappedInstructors, setMappedInstructors] = useState(instructors);

  useEffect(() => {
    userServices
      .getAllInstructors()
      .then((data) => {
        setMappedInstructors(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  function SortPriceASC(){
    const numAscending = [...mappedInstructors].sort((a, b) => a.price - b.price);
    setMappedInstructors(numAscending)
  }
  function SortPriceDESC(){
    const numAscending = [...mappedInstructors].sort((a, b) => b.price - a.price);
    setMappedInstructors(numAscending)
  }
  function SortAddressASC(){
    const numAscending = [...mappedInstructors].sort((a, b) => a.address > b.address ? 1 : -1);
    setMappedInstructors(numAscending)
  }
  function SortAddressDESC(){
    const numAscending = [...mappedInstructors].sort((a, b) => a.address < b.address ? 1 : -1);
    setMappedInstructors(numAscending)
  }
  function SortNameASC(){
    const numAscending = [...mappedInstructors].sort((a, b) => a.name > b.name ? 1 : -1);
    setMappedInstructors(numAscending)
  }
  function SortNameDESC(){
    const numAscending = [...mappedInstructors].sort((a, b) => a.name < b.name ? 1 : -1);
    setMappedInstructors(numAscending)
  }

  return (
    <div>
       <Button onClick={()=>{
        SortAddressASC()
       
      }}>Sort AddressASC</Button>
            <Button onClick={()=>{
        SortAddressDESC()
       
      }}>Sort AddressESC</Button>
            <Button onClick={()=>{
        SortNameASC()
       
      }}>Sort NameASC</Button>
       <Button onClick={()=>{
        SortNameDESC()
       
      }}>Sort NameDESC</Button>
      <div className="header">
        <h1 style={{ textAlign: "center" }}> All Instructors </h1>
      </div>
      {mappedInstructors?.map((instructor) => (
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
