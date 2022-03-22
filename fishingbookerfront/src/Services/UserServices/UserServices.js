const axios = require("axios");

const userServices = {
  signUpUser: (user) => {
    return axios.post(`${process.env.REACT_APP_API_URL}/signup/async`, user);
  },
  createClient: (client) => {
    return axios.post(`${process.env.REACT_APP_API_URL}clients`, client);
  },
  createCottageOwner: (cottageOwner) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}cottageOwners`,
      cottageOwner
    );
  },
  createInstructor: (instrictor) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}instructors`,
      instrictor
    );
  },
  createBoatOwner: (boatOwner) => {
    return axios.post(`${process.env.REACT_APP_API_URL}boatOwners`, boatOwner);
  },
  getAllInstructorRequests: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}instructorRequests`);
  },
  getAllCottageOwnerRequests: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}cottageOwnerRequests`);
  },
  getAllBoatOwnerRequests: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}boatOwnerRequests`);
  },

  activateCottageOwner: (cottageOwner) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}activateCottageOwner/${cottageOwner.id}`
    );
  },
  removeCottageOwner: (cottageOwner) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}removeCottageOwner/${cottageOwner.id}`
    );
  },
  activateBoatOwner: (boatOwner) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}activateBoatOwner/${boatOwner.id}`
    );
  },
  removeBoatOwner: (boatOwner) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}removeBoatOwner/${boatOwner.id}`
    );
  },
  activateInstructor: (instructor) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}activateInstructor/${instructor.id}`
    );
  },
  removeInstructor: (instructor) => {
    console.log("instructor", instructor);
    return axios.put(
      `${process.env.REACT_APP_API_URL}removeInstructor/${instructor.id}`,
      instructor
    );
  },
};

export default userServices;
