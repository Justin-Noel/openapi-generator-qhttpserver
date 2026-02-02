cmake_minimum_required(VERSION 3.16 FATAL_ERROR)

set(CMAKE_VERBOSE_MAKEFILE ON)
set(CMAKE_INCLUDE_CURRENT_DIR ON)
set(CMAKE_AUTOMOC ON)
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

OPTION(NODEBUG  "Deactivate No debugging option" "OFF")

set(CMAKE_C_FLAGS   "${CMAKE_C_FLAGS}   -fPIC -Wall -Wno-unused-variable")
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -fPIC -Wall -Wno-unused-variable")

if(${NODEBUG} STREQUAL "OFF")
set(CMAKE_C_FLAGS   "${CMAKE_C_FLAGS}   -pg -g3")
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -pg -g3")
else (${NODEBUG} STREQUAL "OFF")
set(CMAKE_C_FLAGS   "${CMAKE_C_FLAGS}   -s -O3")
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -s -O3")
endif(${NODEBUG} STREQUAL "OFF")

find_package(Qt6 REQUIRED COMPONENTS Core Network HttpServer)

file(GLOB SRCS
    ${CMAKE_CURRENT_SOURCE_DIR}/models/*.cpp
    ${CMAKE_CURRENT_SOURCE_DIR}/handlers/*.cpp
    ${CMAKE_CURRENT_SOURCE_DIR}/main.cpp
)

include_directories(
    ${CMAKE_CURRENT_SOURCE_DIR}/models
    ${CMAKE_CURRENT_SOURCE_DIR}/handlers
)

add_executable(${PROJECT_NAME} ${SRCS})

target_link_libraries(${PROJECT_NAME}
    Qt6::Core
    Qt6::Network
    Qt6::HttpServer
)

install(TARGETS ${PROJECT_NAME} RUNTIME DESTINATION bin LIBRARY DESTINATION lib ARCHIVE DESTINATION lib)
