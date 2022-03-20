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
};

export default userServices;
