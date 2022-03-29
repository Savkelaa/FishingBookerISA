const axios = require("axios");

const boatServices = {
  getAllBoats: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}boats`);
  },
};

export default boatServices;
